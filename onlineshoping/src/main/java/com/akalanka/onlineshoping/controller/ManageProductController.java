package com.akalanka.onlineshoping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.akalanka.onlineshoping.util.FileUploadUtility;
import com.akalanka.onlineshoping.validator.ProductValidator;
import com.akalanka.shopingbackend.dao.CategoryDao;
import com.akalanka.shopingbackend.dao.ProductsDao;
import com.akalanka.shopingbackend.dto.Category;
import com.akalanka.shopingbackend.dto.Products;;
@Controller
@RequestMapping("/manage")
public class ManageProductController {

	@Autowired
	private CategoryDao categorydao;
	@Autowired
	private ProductsDao productsDao;
	
	private static final Logger logger = LoggerFactory.getLogger(ManageProductController.class);
	
	@RequestMapping(value ="/products",method = RequestMethod.GET)
	public ModelAndView showmanageProducts(@RequestParam(name="operation", required=false) String operation ) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Manage Products");
		
		Products nProducts = new Products();
		
		nProducts.setSupplier_id(1);
		nProducts.setIs_active(true);
		
		mv.addObject("product",nProducts);
		mv.addObject("userclickmanageproducts",true);
		
		if(operation != null) {
			if(operation.equals("products")) {
				mv.addObject("message","Product Submitted Successfully");
			}
			if(operation.equals("category")) {
				mv.addObject("message","Category Added Successfully");
			}
		}
		
		
		return mv;
	}
	
	@RequestMapping(value ="{id}/products",method = RequestMethod.GET)
	public ModelAndView showUpdateProducts(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Manage Products");
		mv.addObject("userclickmanageproducts",true);
		
		//fetch the product
		Products uProducts = productsDao.get(id);
		
		
		mv.addObject("product",uProducts);

		return mv;
	}
	
	
	//handle product manage data
	@RequestMapping(value ="/products",method = RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product")Products mproduct, BindingResult results ,
			Model model,HttpServletRequest request) {
		
		if(mproduct.getId() == 0) {
		new ProductValidator().validate(mproduct, results);
		}else {
			if(!(mproduct.getFile().getOriginalFilename().equals(""))) {
				new ProductValidator().validate(mproduct, results);
			}
		}
		logger.info(mproduct.toString());
		
		if(results.hasErrors()) {
			model.addAttribute("title","Manage Products");
			model.addAttribute("userclickmanageproducts",true);
			model.addAttribute("message","validation Failed For Product Submission");
			//can not use redirect here
			return "page";
		}
		
		if(mproduct.getId() == 0) {
			productsDao.add(mproduct);
		}else {
			productsDao.update(mproduct);
		}
		
		
		if(!mproduct.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request, mproduct.getFile(),mproduct.getCode());
		}
		
		
		return "redirect:/manage/products?operation=products";
	}
	
	
	@RequestMapping(value ="/product/{id}/activation", method = RequestMethod.POST)
	@ResponseBody
	public String handleProductactivation(@PathVariable int id) {
		
		
		Products product = productsDao.get(id);
		boolean isActive = product.isIs_active();
		
		product.setIs_active(!isActive);
		
		productsDao.update(product);
		return (isActive)? "You have Succesfully Deactivated the product with id " + product.getId()
							:"You have Succesfully Activated the product with id " + product.getId();
							
	}
	
	@RequestMapping(value ="/category",method = RequestMethod.POST)
	public String handleCategorySubmission(@ModelAttribute("category")Category category) {
		categorydao.add(category);
		return "redirect:/manage/products?operation=category";
	}
		
	
	
	
	//return categories for all the request mapping
	@ModelAttribute("categories")
	public List<Category> getCategories(){
		return categorydao.list();
	}
	
	
	@ModelAttribute("category")
	public Category addCategory(){
		return new Category();
	}
}
