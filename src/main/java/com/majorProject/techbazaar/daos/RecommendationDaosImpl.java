package com.majorProject.techbazaar.daos;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.majorProject.techbazaar.model.Product;
import com.majorProject.techbazaar.model.Rating;
import com.majorProject.techbazaar.model.User;
@Repository
public class RecommendationDaosImpl implements RecommendationDaos {
	
	@Autowired
	private DataSource dataSource;
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private RatingDaos ratingdaos;
	@Autowired
	private ProductDaos productdaos;
	
	private int[][] ratingMatrix;
	private int totalUsers, totalProducts;
	
	private ArrayList<Integer> productToPredict = new ArrayList<Integer>();
	private ArrayList<Product> recommendedProduct = new ArrayList<Product>();

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getRecommenatedProduct(User user) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.setProjection(Projections.rowCount());
		List list = criteria.list();
		totalUsers = Integer.parseInt(list.get(0).toString());
		list.clear();
		criteria = session.createCriteria(Product.class);
		criteria.setProjection(Projections.rowCount());
		list = criteria.list();
		totalProducts=Integer.parseInt(list.get(0).toString());
		createMatrix();
		productToBePredicated(user.getId());
		int[][] result = prediction(user.getId());
		session.close();
		recommendedProduct.clear();
		for(int i=0; i<productToPredict.size();i++){
			recommendedProduct.add(productdaos.getById(result[i][0]));
		}
		return recommendedProduct;
	}
	
	public void createMatrix(){
		ratingMatrix = new int[totalUsers][totalProducts];
		for (int i = 0; i<ratingMatrix.length; ++i)
		{
			for (int j = 0; j<ratingMatrix[0].length; ++j)
			{
				ratingMatrix[i][j] = -1;
			}
		}
		List<Rating> totalRating = ratingdaos.getAllRating();
		for(Rating individualRating:totalRating){
			int userID = individualRating.getUser().getId();
			int productID= individualRating.getProduct().getId();
			int indvRating = individualRating.getRating();
			ratingMatrix[userID-1][productID-1] =indvRating;
		}
		
	}
	
	public void productToBePredicated(int userId){
		productToPredict.clear();
		for(int i=0; i<ratingMatrix[0].length; i++){
			if(ratingMatrix[userId-1][i] == -1){
				productToPredict.add(i+1);
			}
		}
	}
	
	public int[][] prediction(int userid){
		int len =productToPredict.size();
		float[][] opRating = new float[len][2];
		int[][] result = new int[len][2];
		int user = userid;
		int product = 0;
		for (int i = 0; i < len; ++i)
		{
			product = productToPredict.get(i);
			float upperNum = 0;
			float upperDenom = 0;
			for (int j = 0; j < totalProducts; ++j)
			{
				if(user>0){
					if(ratingMatrix[user-1][j] != -1)
					{
						float num = 0;
						float denom1 = 0;
						float denom2 = 0;
						boolean flag = false;
						for (int k = 0; k < totalUsers; ++k)
						{
							if ((ratingMatrix[k][product-1] != -1) && (ratingMatrix[k][j] != -1))
							{
								flag = true;
								num += (float)ratingMatrix[k][product-1]*ratingMatrix[k][j];
								denom1 += (float)ratingMatrix[k][product-1]*ratingMatrix[k][product-1];
								denom2 += (float)ratingMatrix[k][j]*ratingMatrix[k][j];
							}
						}
						if (flag)
						{
							upperDenom += num/(Math.sqrt(denom1*denom2));
							upperNum += ratingMatrix[user-1][j]*num/(Math.sqrt(denom1*denom2));	
						}
					}
				}
				
			}

			float predrating = 0;

			if (upperDenom > 0)
			{
				predrating = upperNum/upperDenom;		
			}
			else
			{
				predrating = upperNum;
			}
			opRating[i][0] = product;
			opRating[i][1] = predrating;
			
		}
		result = sortProduct(opRating);
		return result;
		
	}
	public int[][] sortProduct(float[][] opRating){
		int size=productToPredict.size();
		float[] temp = new float[2];
		int[][] sorted = new int[size][2];
		for(int i = 0; i<size; i++){
			for(int j = i+1; j<size; j++){
				if(opRating[i][1]<opRating[j][1]){
					temp=opRating[i];
					opRating[i]=opRating[j];
					opRating[j]=temp;
				}
				
				
			}
			
		}
		for(int i = 0; i<size;i++){
			System.out.println(opRating[i][0]+" "+opRating[i][1]);
		}
		
		for(int i=0; i <size; i++){
			System.out.println("count "+i);
			sorted[i][0]=(int)opRating[i][0];
			sorted[i][1]=(int) Math.round(opRating[i][1]);
		}
		return sorted;
	}

}
