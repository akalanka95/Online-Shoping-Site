package com.akalanka.shopingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.akalanka.shopingbackend.dao.CategoryDao;
import com.akalanka.shopingbackend.dao.ProductsDao;
import com.akalanka.shopingbackend.dto.Category;
import com.akalanka.shopingbackend.dto.Products;

public class ProductTestClass {

	private static AnnotationConfigApplicationContext context;
	private static ProductsDao productsDao;
	private Products products;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.akalanka.shopingbackend");
		context.refresh();
		productsDao = (ProductsDao)context.getBean("productsDao");
	}
	 
	@Test
	public void testCrudOfAllCategories() {
		//add categories
		products = new Products();
		products.setName("octapad");
		products.setBrand("Yamaha");
		products.setDescription("this is branded one");
		products.setIs_active(true);
		products.setCategory_id(2);
		products.setQuantity(3);
		products.setSupplier_id(1);
		products.setUnit_price(120.00);
		
		assertEquals("successfully added",true,productsDao.add(products));
		
		products = new Products();
		products.setName("drum");
		products.setBrand("Yamaha");
		products.setDescription("this is branded one");
		products.setIs_active(true);
		products.setCategory_id(2);
		products.setQuantity(3);
		products.setSupplier_id(1);
		products.setUnit_price(120.00);
		
		assertEquals("successfully added",true,productsDao.add(products));
		
		products = new Products();
		products.setName("organ");
		products.setBrand("Yamaha");
		products.setDescription("this is branded one");
		products.setIs_active(true);
		products.setCategory_id(2);
		products.setQuantity(3);
		products.setSupplier_id(1);
		products.setUnit_price(120.00);
		
		assertEquals("successfully added",true,productsDao.add(products));

		//Fetch a category 
		products = productsDao.get(1);
		assertEquals("successfully fetch a single category","octapad",products.getName());
		
		
		//Update a Category
		products = productsDao.get(1);
		products.setName("Violin");
		assertEquals("Done the update",true,productsDao.update(products));
		
		
		//Delete a category
		products = productsDao.get(2);
		assertEquals("Done the deletion",true,productsDao.delete(products));
		
		//Fetch a list of Category
		assertEquals("Done with fetching the list of categories",1,productsDao.list().size());
		
		//Fetch listofActiveCategory
		assertEquals("Done with fetching the list of categories",1,productsDao.listActiveProducts().size());
		
		//Fetch listofactiveproductsbycategory
		assertEquals("Done with fetching the list of categories",1,productsDao.listActiveProductsByCategory(2).size());
		
		//Fetch listoflatestactiveproducts
		assertEquals("Done with fetching the list of categories",4,productsDao.listLatestActiveProducts(4));
		
	}
	
	
	
}
