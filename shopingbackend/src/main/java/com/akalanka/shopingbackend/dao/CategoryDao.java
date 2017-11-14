package com.akalanka.shopingbackend.dao;

import java.util.List;

import com.akalanka.shopingbackend.dto.Category;

public interface CategoryDao {

	List<Category> list();
	Category get(int id);
}
