package com.akalanka.onlineshoping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cart") 
public class CartController {

	@RequestMapping("/show") 
	public ModelAndView showCart() {
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("title" ,"User Cart");
		mv.addObject("userclickshowcart",true);
		mv.addObject("cartLines",null);
		
		return mv;
		
	}
	
	
	
}
