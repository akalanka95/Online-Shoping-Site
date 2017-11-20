package com.akalanka.shopingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.akalanka.shopingbackend.dao.CartLineDao;
import com.akalanka.shopingbackend.dao.ProductsDao;
import com.akalanka.shopingbackend.dao.UserDao;
import com.akalanka.shopingbackend.dto.Cart;
import com.akalanka.shopingbackend.dto.CartLine;
import com.akalanka.shopingbackend.dto.Products;
import com.akalanka.shopingbackend.dto.User;

public class CartLineTest {

	private static AnnotationConfigApplicationContext context;
	private static CartLineDao cartLineDao = null;
	private static ProductsDao productsDao = null;
	private static UserDao userDao = null;
	
	private Products product = null ;
	private User user = null;
	private Cart cart= null;
	private CartLine cartLine = null;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.akalanka.shopingbackend");
		context.refresh();
		productsDao = (ProductsDao)context.getBean("productsDao");
		userDao = (UserDao)context.getBean("userDao");
		cartLineDao = (CartLineDao)context.getBean("cartLineDao");

	}
	
	
	
	@Test
	public void testAddNewCartLine() {
		
		user = userDao.getUserByEmail("aj@gmail.com");
		
		cart = user.getCart();
		
		product = productsDao.get(1);
		
		cartLine = new CartLine();
		cartLine.setBuyingPrice(product.getUnit_price());
		cartLine.setProductCount(cartLine.getProductCount() + 1);
		cartLine.setTotal(cartLine.getProductCount() * product.getUnit_price());
		cartLine.setAvailable(true);
		cartLine.setCartId(cart.getId());
		cartLine.setProducts(product);
		
		assertEquals("failed  add to the cartLine ", true , cartLineDao.add(cartLine));
		
		cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal()); 
		cart.setCartLines(cart.getCartLines() + 1);
		
		assertEquals("failed update the cart ", true , cartLineDao.updateCart(cart));
		
	}
	
	
	
}
