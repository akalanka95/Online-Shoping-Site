package com.akalanka.shopingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.akalanka.shopingbackend.dao.CategoryDao;
import com.akalanka.shopingbackend.daoim.CategoryDaoIm;
import com.akalanka.shopingbackend.dto.Category;

public class CategortTestClass {

	private static AnnotationConfigApplicationContext context;
	private static CategoryDao categoryDao;
	private Category category;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.akalanka.shopingbackend");
		context.refresh();
		categoryDao = (CategoryDao)context.getBean("categoryDaoIm",CategoryDao.class);
	}
	
	/*@Test
	public void testAddCategory() {
		category = new Category();
		category.setName("Base Guitar");
		category.setDescription("This is about base guitar");
		category.setImageUrl("base.png");
		assertEquals("successfully added",true,categoryDao.add(category));
		
	}*/
	
	/*@Test
	public void testGetCategory() {
		category = categoryDao.get(1);
		assertEquals("successfully fetch a single category","Base Guitar",category.getName());
	}*/
	
	/*@Test
	public void testUpdatecategory() {
		category = categoryDao.get(1);
		category.setName("drums And Guitars");
		assertEquals("Done the update",true,categoryDao.update(category));
	}*/
	
	/*@Test
	public void testDeleteCategory() {
		category = categoryDao.get(1);
		assertEquals("Done the update",true,categoryDao.delete(category));
	}*/
	
	/*@Test
	public void testLstOfCategory() {
		assertEquals("Done twith fetching the list of categories",3,categoryDao.list().size());
	}*/
	
	@Test
	public void testCrudOfAllCategories() {
		//add categories
		category = new Category();
		category.setName("Guitars");
		category.setDescription("This is about base guitar");
		category.setImageUrl("guitar.png");
		
		assertEquals("successfully added",true,categoryDao.add(category));
		
		category = new Category();
		category.setName("Drums");
		category.setDescription("This is about drums");
		category.setImageUrl("drum.png");
		
		assertEquals("successfully added",true,categoryDao.add(category));
		
		category = new Category();
		category.setName("Piano");
		category.setDescription("This is about piano");
		category.setImageUrl("piano.png");
		
		assertEquals("successfully added",true,categoryDao.add(category));
		
		//Fetch a category 
		category = categoryDao.get(1);
		assertEquals("successfully fetch a single category","Guitars",category.getName());
		
		
		//Update a Category
		category = categoryDao.get(1);
		category.setName("Violin");
		assertEquals("Done the update",true,categoryDao.update(category));
		
		
		//Delete a category
		category = categoryDao.get(1);
		assertEquals("Done the deletion",true,categoryDao.delete(category));
		
		//Fetch a list of Category
		assertEquals("Done twith fetching the list of categories",1,categoryDao.list().size());
		
	}
	
}
