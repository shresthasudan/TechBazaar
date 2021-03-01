package com.majorProject.techbazaar.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.majorProject.techbazaar.daos.CartDaos;
import com.majorProject.techbazaar.daos.ProductDaos;
import com.majorProject.techbazaar.daos.PurchasedDaos;
import com.majorProject.techbazaar.daos.UserCartDaos;
import com.majorProject.techbazaar.daos.UserDaos;
import com.majorProject.techbazaar.model.Cart;
import com.majorProject.techbazaar.model.Product;
import com.majorProject.techbazaar.model.Purchased;
import com.majorProject.techbazaar.model.User;
import com.majorProject.techbazaar.model.UserCart;
import com.majorProject.techbazaar.util.GetDate;

@Controller
public class CartController {

	@Autowired
	private CartDaos cartDaos;
	@Autowired
	private ProductDaos productdaos;
	@Autowired
	private UserDaos userdaos;
	@Autowired
	private PurchasedDaos purchasedDaos;
	@Autowired
	private UserCartDaos userCartdaos;
	
	
	@RequestMapping(value="/{id}/cart",method=RequestMethod.GET)
	public String cartDetail(@PathVariable("id")int id,@ModelAttribute Cart c,Model model,HttpSession session){
		session.setAttribute("cartList", cartDaos.getAllCartProduct(id));
		session.setAttribute("userTotal", cartDaos.getTotalAmount(id));
		
		return "cartPage";
	}
	
	@RequestMapping(value="/{id}/addToCart", method=RequestMethod.GET)
	public String AddProduct(@PathVariable("id") int id,@ModelAttribute Cart c,@ModelAttribute Product p,@ModelAttribute User u, Model model,HttpSession session){
	
		//c.setProductId(id);
		String userId=session.getAttribute("id").toString();
		int Uid=Integer.parseInt(userId);
		u=userdaos.getUser(Uid);
		UserCart uc = userCartdaos.getUserCart(u);
		c.setUserCart(uc);
		p =productdaos.getById(id);
		c.setProduct(p);
		c.setQuantity(1);
		c.setStatus("booked");
		c.setSubTotal(p.getUnit_price()*c.getQuantity());
		//c.setUserId(Uid);
		boolean check= cartDaos.checkCart(Uid, id);
		if(check){
			cartDaos.addToCart(c);
			return "redirect:/home";
		}else{
			session.setAttribute("cartList", cartDaos.getAllCartProduct(Uid));
			session.setAttribute("userTotal", cartDaos.getTotalAmount(Uid));
			return "cartPage";
		}
		//cartDaos.addToCart(c);
		//return "redirect:/home";
		
	}
	
	@RequestMapping(value="/{Cid}/removeCart", method=RequestMethod.GET)
	public String removeCart(@PathVariable("Cid") int Cid,HttpSession session, Model model){
		int id=Integer.parseInt(session.getAttribute("id").toString());
		cartDaos.deletecart(Cid);
		session.setAttribute("cartList", cartDaos.getAllCartProduct(id));
		session.setAttribute("userTotal", cartDaos.getTotalAmount(id));
		return "cartPage";
	}
	@RequestMapping(value="/MakeOrder",method=RequestMethod.GET)
	public String makeOrder(@ModelAttribute Purchased purchased,@ModelAttribute Cart c ,HttpSession session,Model model){
		int id=Integer.parseInt(session.getAttribute("id").toString());
		String date= GetDate.Today();
		List<Cart> cartList = cartDaos.getAllCartProduct(id);
		for(Cart cart:cartList){
			int previousQuantity=cart.getProduct().getQuantity();
			int orderedQuantity=cart.getQuantity();
			//if(previousQuantity>=orderedQuantity)
			int updateQuantity=previousQuantity-orderedQuantity;
			Product pro=productdaos.getById(cart.getProduct().getId());
			pro.setQuantity(updateQuantity);
			productdaos.updateProduct(pro);
			purchased.setCart(cart);
			purchased.setOrderedDate(date);
			purchasedDaos.addPurchased(purchased);
			cart.setStatus("ordered");
			cartDaos.updateCart(cart);
		}
		session.setAttribute("cartList", cartDaos.getAllCartProduct(id));
		session.setAttribute("userTotal", cartDaos.getTotalAmount(id));
		return "cartPage";
	}
	@RequestMapping(value="/{cartId}/updateCart",method=RequestMethod.GET)
	public String UpdateCart(@PathVariable("cartId") int cartId,@ModelAttribute Cart cart,@ModelAttribute Product product,@RequestParam int count, HttpSession session,Model model){
		int id=Integer.parseInt(session.getAttribute("id").toString());
		cart=cartDaos.getCart(cartId);
		cart.setQuantity(count);
		cart.setSubTotal(cart.getProduct().getUnit_price()*cart.getQuantity());
		cartDaos.updateCart(cart);
		session.setAttribute("cartList", cartDaos.getAllCartProduct(id));
		session.setAttribute("userTotal", cartDaos.getTotalAmount(id));
		return "cartPage";
	}
	
	
}
