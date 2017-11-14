package com.akalanka.onlineshoping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.akalanka.shopingbackend.dao.CategoryDao;
import com.akalanka.shopingbackend.dto.Category;

@Controller
public class PageController {

	@Autowired
	private CategoryDao categoryDao;
	
	
	@RequestMapping(value = { "/", "home", "index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Home");
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
