package com.akalanka.onlineshoping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.akalanka.onlineshoping.exception.ProductNotFoundException;
import com.akalanka.shopingbackend.dao.CategoryDao;
import com.akalanka.shopingbackend.dao.ProductsDao;
import com.akalanka.shopingbackend.dto.Category;
import com.akalanka.shopingbackend.dto.Products;

@Controller
public class PageController {

	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private ProductsDao productDao;
	
	@RequestMapping(value = { "/", "home", "index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Home");
		logger.info("Inside PageContoller index method-INFO");
		logger.debug("Inside PageContoller index method-DEBUG");
		mv.addObject("categories",categoryDao.list());
		mv.addObject("userclickhome",true);
		return mv;
	}
	
	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","About us");
		mv.addObject("userclickabout",true);
		return mv;
	}
	
	@RequestMapping(value = "/listproducts")
	public ModelAndView listproducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Products");
		mv.addObject("userclickproduct",true);
		return mv;
	}
	
	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Contact");
		mv.addObject("userclickcontact",true);
		return mv;
	}
	
	@RequestMapping(value = "show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","All Products");
		mv.addObject("categories",categoryDao.list());
		mv.addObject("userclickallproducts",true);
		return mv;
	}
	
	
	@RequestMapping(value = "show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		
		Category category = null;
		category = categoryDao.get(id);
				
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title",category.getName());
		mv.addObject("categories",categoryDao.list());
		mv.addObject("category",category);
		mv.addObject("userclickcategoryproducts",true);
		return mv;
	}
	
	
	@RequestMapping(value = "show/{id}/products")
	public ModelAndView showsinglePageProduct(@PathVariable("id") int id) throws ProductNotFoundException {
		
		Products product = null;
		product = productDao.get(id);
				
		if(product == null) throw new ProductNotFoundException();
		
		ModelAndView mv = new ModelAndView("page");
		
		//update view
		product.setViews(product.getViews() + 1);
		productDao.update(product);
		
		mv.addObject("title",product.getName());
		mv.addObject("product",product);
		mv.addObject("userclicksinglepageproduct",true);
		return mv;
	}
	
	@RequestMapping(value = "/login")
	public ModelAndView test(@RequestParam(name="error",required = false)String error
			,@RequestParam(name="logout",required = false)String logout) {
		ModelAndView mv = new ModelAndView("login");
		
		if(error != null) {
			mv.addObject("message","Invalid UserName and Passwod");
		}
		
		if(logout != null) {
			mv.addObject("logout","User has successfully Logged out!");
		}
		
		mv.addObject("title","Login");
		return mv;
	}
	
	@RequestMapping(value = "/access-denied")
	public ModelAndView accessDenied() {
		ModelAndView mv = new ModelAndView("error");	
		mv.addObject("title","403 - Access Denied ");
		mv.addObject("errorTitle","403 - Get Caught ");
		mv.addObject("errorDescription","403 - No authoriztion ");
		return mv;
	}
	
	@RequestMapping(value = "/perform-logout")
	public String performLogout(HttpServletRequest request,HttpServletResponse response) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if( auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}

		return "redirect:/login?logout"; 	
	}
	
	
	
	/*@RequestMapping(value = "/test")
	public ModelAndView test(@RequestParam(value="greeting", required=false)String greeting) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting",greeting);
		return mv;
	}
	
	@RequestMapping(value = "/test/{greeting}")
	public ModelAndView test2(@PathVariable(value="greeting", required=false)String greeting) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting",greeting);
		return mv;
	}
	*/
}
