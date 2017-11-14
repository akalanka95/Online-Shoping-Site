package com.akalanka.shopingbackend.daoim;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.akalanka.shopingbackend.dao.CategoryDao;
import com.akalanka.shopingbackend.dto.Category;

@Repository
public class CategoryDaoIm implements CategoryDao {

	private static List<Category> categories = new ArrayList<>();
	
	static {
		Category category = new Category();
		category.setId(1);
		category.setName("Drums");
		category.setDescription("this is about drums");
		category.setImageUrl("drum.png");
		
		categories.add(category);
		
		
		category = new Category();
		category.setId(2);
		category.setName("Guitars");
		category.setDescription("this is about guitars");
		category.setImageUrl("guitar.png");
		
		categories.add(category);
		
		
		category = new Category();
		category.setId(3);
		category.setName("Pianos");
		category.setDescription("this is about pianos");
		category.setImageUrl("piano.png");
		
		categories.add(category);
		
	}
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {
		
		for(Category category :categories) {
			if(category.getId() == id)return category;
		}
		return null;
	}

}
