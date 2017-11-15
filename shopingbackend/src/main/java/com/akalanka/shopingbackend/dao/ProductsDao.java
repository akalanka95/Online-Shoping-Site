package com.akalanka.shopingbackend.dao;

import java.util.List;

import com.akalanka.shopingbackend.dto.Products;



public interface ProductsDao {

	Products get(int id);
	List<Products> list();
	boolean add(Products products);
	boolean update(Products products);
	boolean delete(Products products);
	
	List<Products> listActiveProducts();
	List<Products> listActiveProductsByCategory(int category_id);
	List<Products> listLatestActiveProducts(int count);
}
