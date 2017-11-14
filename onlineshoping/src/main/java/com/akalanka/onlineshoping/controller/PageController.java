package com.akalanka.onlineshoping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@RequestMapping(value = { "/", "home", "index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Home");
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
		mv.addObject("title","Poducts");
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
