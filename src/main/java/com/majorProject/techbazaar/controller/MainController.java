package com.majorProject.techbazaar.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.majorProject.techbazaar.daos.CommentDaos;
import com.majorProject.techbazaar.daos.ProductDaos;
import com.majorProject.techbazaar.daos.PurchasedDaos;
import com.majorProject.techbazaar.daos.RatingDaos;
import com.majorProject.techbazaar.daos.RecommendationDaos;
import com.majorProject.techbazaar.daos.SupplierDaos;
import com.majorProject.techbazaar.daos.UserDaos;
import com.majorProject.techbazaar.daos.categoryDaos;
import com.majorProject.techbazaar.model.Category;
import com.majorProject.techbazaar.model.Comment;
import com.majorProject.techbazaar.model.Product;
import com.majorProject.techbazaar.model.Purchased;
import com.majorProject.techbazaar.model.Rating;
import com.majorProject.techbazaar.model.Supplier;
import com.majorProject.techbazaar.model.User;
import com.majorProject.techbazaar.util.GetDate;
import com.majorProject.techbazaar.util.uploadFileUtil;

@Controller
public class MainController {

	@Autowired
	private categoryDaos categorydaos;
	@Autowired
	private ProductDaos productdaos;
	@Autowired
	private PurchasedDaos purchasedDaos;
	@Autowired
	private UserDaos userDaos;
	@Autowired
	private CommentDaos commentdaos;
	@Autowired
	private RatingDaos ratingdaos;
	@Autowired
	private SupplierDaos supplierdaos;
	@Autowired
	private RecommendationDaos recommendationdaos;

	@RequestMapping(value = {"/" , "/home"}, method = RequestMethod.GET)
	public String home(@ModelAttribute Category c, Model model, HttpSession session) {
		session.setAttribute("title", "Home");
		session.setAttribute("categoryList", categorydaos.getAllCategory());
		session.setAttribute("productList",productdaos.getAllProduct());
		return "home";
	}

	@RequestMapping(value = "/AddProduct", method = RequestMethod.GET)
	public String getmanage(@ModelAttribute Category c, Model model, HttpSession session) {
		session.setAttribute("title", "Manage Product");
		session.setAttribute("categoryList", categorydaos.getAllCategory());
		session.setAttribute("supplierList", supplierdaos.getAllSupplier());
		
		return "managePage";
	}

	@RequestMapping(value = "/AddProduct", method = RequestMethod.POST)
	public String manage(@RequestParam("categoryId") int cid, @RequestParam("supplierId") int sid, @ModelAttribute Product p, Model model, HttpSession session,HttpServletRequest request) {
		//p.setSupplier_id(supplier_id);//--supplier_id path variables 
		float percent_limit=(float) 0.1;
		int quantity= p.getQuantity();
		float limit = percent_limit*quantity;
		int numberLimit=Math.round(limit);
		if(numberLimit<1){
			numberLimit=1;
		}
		//p.setCategory(category);
		p.setQuantity_limit(numberLimit);
		p.setCategory(categorydaos.getcategory(cid));
		p.setSupplier(supplierdaos.getSupplier(sid));
		p.setEntryDate(GetDate.Today());
		productdaos.addProduct(p);
		if (!p.getFile().getOriginalFilename().equals("")) {
			uploadFileUtil.uploadFile(request,p.getFile(),p.getCode());
		}else{
			System.out.println("no image");
		}
		return "managePage";
	}

	@RequestMapping(value = "/AddCategory", method = RequestMethod.GET)
	public String getmanageCategory(@ModelAttribute Category c, Model model, HttpSession session) {
		session.setAttribute("title", "Manage Category");
		session.setAttribute("categoryList", categorydaos.getAllCategory());
		session.setAttribute("supplierList", supplierdaos.getAllSupplier());
		return "manageCategory";
	}

	@RequestMapping(value = "/AddCategory", method = RequestMethod.POST)
	public String manageCategory(@ModelAttribute Category c, Model model, HttpSession session) {
		categorydaos.addCategory(c);
		session.setAttribute("categoryList", categorydaos.getAllCategory());
		session.setAttribute("supplierList", supplierdaos.getAllSupplier());
		return "manageCategory";
	}
	@RequestMapping(value="/category/all",method=RequestMethod.GET)
	public String allProductView(@ModelAttribute Product p, Model m,HttpSession session){
		session.setAttribute("title", "View All Products");
		session.setAttribute("productList", productdaos.getAllProduct());
		session.setAttribute("breadcrumTag", "All Product");
		m.addAttribute("clickedCategory", true);
		return "viewProducts";
	}
	@RequestMapping(value="/category/{id}/all",method=RequestMethod.GET)
	public String categoryProduct(@PathVariable("id") int id,Model model,HttpSession session){
		session.setAttribute("title", "View Similar Products");
		session.setAttribute("productList", productdaos.getAllProductById(id));
		model.addAttribute("clickedId", true);
		session.setAttribute("breadcrumTagName", categorydaos.getCategoryById(id));
		return "viewProducts";
	}
	
	@RequestMapping(value="/ViewOrders",method=RequestMethod.GET)
	public String viewOrders(Model model, HttpSession session){
		session.setAttribute("orderList", purchasedDaos.getAllOrder());
		return "viewOrder";
	}
	
	@RequestMapping(value="/PurchasedList",method=RequestMethod.GET)
	public String viewPurchased(Model model, HttpSession session){
		session.setAttribute("purchasedList", purchasedDaos.getAllPurchased());
		return "purchasedPage";
	}
	
	@RequestMapping(value="/{Pid}/Deliver",method=RequestMethod.GET)
	public String deliverItem(@PathVariable("Pid") int Pid,@ModelAttribute Purchased purchased,HttpSession session,Model model){
		purchased=purchasedDaos.getById(Pid);
		purchased.setDeliveredDate(GetDate.Today());
		purchased.setStatus("delivered");
		purchasedDaos.updatePurchased(purchased);
		session.setAttribute("orderList", purchasedDaos.getAllOrder());
		return "viewOrder";
	}
	@RequestMapping(value="/StaffList",method=RequestMethod.GET)
	public String getStaffList(@ModelAttribute User user,HttpSession session){
		session.setAttribute("userList", userDaos.getAllStaff());
		session.setAttribute("title", "Staff List");
		session.setAttribute("list", "staff");
		return "userList";
	}
	@RequestMapping(value="/UserList",method=RequestMethod.GET)
	public String getUserList(@ModelAttribute User user,HttpSession session){
		session.setAttribute("userList", userDaos.getAllUser());
		session.setAttribute("title", "User List");
		session.setAttribute("list", "user");
		return "userList";
	}
	@RequestMapping(value="/{Uid}/promoteUser",method=RequestMethod.GET)
	public String promoteUser(@PathVariable("Uid") int Uid,@ModelAttribute User user,HttpSession session){
		user=userDaos.getUser(Uid);
		user.setRole("staff");
		userDaos.updateUser(user);
		session.setAttribute("userList", userDaos.getAllUser());
		return "userList";
	}
	@RequestMapping(value="/{Uid}/DemoteUser",method=RequestMethod.GET)
	public String demoteUser(@PathVariable("Uid") int Uid,@ModelAttribute User user,HttpSession session){
		user=userDaos.getUser(Uid);
		user.setRole("user");
		userDaos.updateUser(user);
		session.setAttribute("userList", userDaos.getAllStaff());
		return "userList";
	}
	@RequestMapping(value="/{pid}/view",method=RequestMethod.GET)
	public String viewSingleProduct(@PathVariable("pid") int pid,@ModelAttribute Product product,User user, HttpSession session, HttpServletRequest request){
		product=productdaos.getById(pid);
		if(session.getAttribute("username")!=null){
			int userId=Integer.parseInt(session.getAttribute("id").toString());
			user=userDaos.getUser(userId);
			session.setAttribute("yourRating", ratingdaos.getPreviousRating(user, product));
		}
		
		session.setAttribute("title", product.getName());
		session.setAttribute("p", product);
		int views = product.getViews();
		product.setViews(views + 1);
		productdaos.updateProduct(product);
		session.setAttribute("totalRating", ratingdaos.getTotalRatingOfProduct(product));
		session.setAttribute("productReview", commentdaos.getAllCommentByProductId(product));
		return "viewSingleProduct";
	}
	@RequestMapping(value="/addComment",method=RequestMethod.GET)
	public String addReview(@ModelAttribute Comment cmt,@RequestParam("cmt") String comment,User user, Product product, HttpSession session,Model model){
		int userId=Integer.parseInt(session.getAttribute("id").toString());
		user=userDaos.getUser(userId);
		product=(Product) session.getAttribute("p");
		cmt.setProduct(product);
		cmt.setUser(user);
		cmt.setComment(comment);
		boolean check=commentdaos.checkComment(comment,product, user);
		if(check){
			commentdaos.addComment(cmt);
			session.setAttribute("productReview", commentdaos.getAllCommentByProductId(product));
		}
		session.setAttribute("yourRating", ratingdaos.getPreviousRating(user, product));
		session.setAttribute("totalRating", ratingdaos.getTotalRatingOfProduct(product));
		return "viewSingleProduct";
	}
	private int count;
	@RequestMapping(value="/{pid}/updateProduct",method=RequestMethod.GET)
	public String updateQuantity(@PathVariable("pid") int pid, Model model){
		Product product=productdaos.getById(pid);
		count =product.getQuantity();
		model.addAttribute("product", product);
		return "updateProduct";
	}
	@RequestMapping(value="updateQuantity", method=RequestMethod.POST)
	public String updateQuantityPost(@ModelAttribute Product pro){
		int newquantity=pro.getQuantity();
		newquantity+=count;
		pro.setQuantity(newquantity);
		float percent_limit=(float) 0.1;
		float limit = percent_limit*newquantity;
		int numberLimit=Math.round(limit);
		if(numberLimit<1){
			numberLimit=1;
		}
		pro.setQuantity_limit(numberLimit);
		
		productdaos.updateProduct(pro);
		return "redirect:/home";
	}
	@RequestMapping(value="/{pid}/updateproductinfo",method=RequestMethod.GET)
	public String updateproductinfo(@PathVariable int pid,Model model){
		Product product=productdaos.getById(pid);
		model.addAttribute("product",product);
		return "updateProductInfo";
	}
	@RequestMapping(value="updateProductInformation", method=RequestMethod.POST)
	public String updateProductInformation(@ModelAttribute Product product){
		productdaos.updateProduct(product);
		return "redirect:/home";
	}
	@RequestMapping(value="addRating", method=RequestMethod.GET)
	public String addRating(@ModelAttribute Rating rating, Product product, User user, @RequestParam int rate, HttpSession session){
		int UserId=Integer.parseInt(session.getAttribute("id").toString());
		user=userDaos.getUser(UserId);
		product=(Product) session.getAttribute("p");
		boolean checkRatingFlag = ratingdaos.checkRating(user, product);
		if(checkRatingFlag){
			rating.setUser(user);
			rating.setProduct(product);
			rating.setRating(rate);
			ratingdaos.addRating(rating);
		}else{
			Rating userRate=ratingdaos.getRating(user, product);
			userRate.setRating(rate);
			ratingdaos.updateRating(userRate);
		}
		
		session.setAttribute("yourRating", ratingdaos.getPreviousRating(user, product));
		session.setAttribute("totalRating", ratingdaos.getTotalRatingOfProduct(product));
		session.setAttribute("productReview", commentdaos.getAllCommentByProductId(product));
		return "viewSingleProduct";
	}
	@RequestMapping(value = "/AddSupplier", method = RequestMethod.GET)
	public String getmanageSupplier(@ModelAttribute Supplier s, Model model, HttpSession session) {
		session.setAttribute("title", "Manage Supplier");
		session.setAttribute("categoryList", categorydaos.getAllCategory());
		session.setAttribute("supplierList", supplierdaos.getAllSupplier());
		return "addSupplier";
	}

	@RequestMapping(value = "/AddSupplier", method = RequestMethod.POST)
	public String manageSupplier(@ModelAttribute Supplier s, Model model, HttpSession session) {
		supplierdaos.addSupplier(s);
		session.setAttribute("categoryList", categorydaos.getAllCategory());
		session.setAttribute("supplierList", supplierdaos.getAllSupplier());
		return "addSupplier";
	}
	@RequestMapping(value="/recommendation", method=RequestMethod.GET)
	public String recommendProduct(@ModelAttribute Product p, HttpSession session){
		session.setAttribute("title", "Recommendation");
		session.setAttribute("categoryList", categorydaos.getAllCategory());
		int uid= (Integer) session.getAttribute("id");
		User user = userDaos.getUser(uid);
		session.setAttribute("productList",recommendationdaos.getRecommenatedProduct(user));
		return "home";
	}
	
	
//	@RequestMapping(value="/searchProduct", method = RequestMethod.GET)
//	public String searchProduct(@RequestParam("key")String key, HttpSession session){
//		session.setAttribute("productList", productdaos.getProductsByTag(key));
//		
//		return null;
//	}
	
}
