package com.akalanka.onlineshoping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.akalanka.shopingbackend.dao.ProductsDao;
import com.akalanka.shopingbackend.dto.Category;
import com.akalanka.shopingbackend.dto.Products;

@Controller
@RequestMapping("json/data")
public class JsonDataController {

	@Autowired
	private ProductsDao productsDao;
	
	@RequestMapping("/all/products")
	@ResponseBody
	public List<Products> listAllProducts(){
		
		return productsDao.listActiveProducts();
		
	}
	
	
	@RequestMapping("admin/all/products")
	@ResponseBody
	public List<Products> listAllProductsForAdmin(){
		
		return productsDao.list();
		
	}
	
	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Products> listCategoryProducts(@PathVariable("id") int id) {
		
		return productsDao.listActiveProductsByCategory(id);
				
	
	}
}
