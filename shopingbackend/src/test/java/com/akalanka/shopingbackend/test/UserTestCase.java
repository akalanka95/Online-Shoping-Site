package com.akalanka.shopingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.akalanka.shopingbackend.dao.UserDao;
import com.akalanka.shopingbackend.dto.Address;
import com.akalanka.shopingbackend.dto.Cart;
import com.akalanka.shopingbackend.dto.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDao userDao;
	private Address address;
	private User user = null;
	private Cart cart = null;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.akalanka.shopingbackend");
		context.refresh();
		userDao = (UserDao) context.getBean("userDao");
	}

	/*
	 * @Test public void testAdd() { user = new User();
	 * user.setFirstName("akalanka"); user.setLastName("gamage");
	 * user.setEmai("ak@gmail.com"); user.setContactNumber("23566");
	 * user.setRole("USER"); user.setPassword("1234");
	 * 
	 * 
	 * assertEquals("Failed to add user",true,userDao.addUser(user));
	 * 
	 * 
	 * address = new Address(); address.setAddressLineOne(" no 73");
	 * address.setAddressLineTwo("horana"); address.setCity("horana");
	 * address.setCountry("sri lanka"); address.setPostalCode("12400");
	 * address.setBilling(true);
	 * 
	 * address.setUserId(user.getId());
	 * 
	 * assertEquals("Failed to add address",true,userDao.addAddress(address));
	 * 
	 * if(user.getRole().equals("USER")){
	 * 
	 * cart = new Cart(); cart.setUser(user);
	 * 
	 * assertEquals("Failed to add cart",true,userDao.addCart(cart));
	 * 
	 * address = new Address(); address.setAddressLineOne(" no 73shipping");
	 * address.setAddressLineTwo("horana"); address.setCity("horana");
	 * address.setCountry("sri lanka"); address.setPostalCode("12400");
	 * address.setShipping(true);
	 * 
	 * address.setUserId(user.getId());
	 * 
	 * 
	 * assertEquals("Failed to add cart",true,userDao.addAddress(address));
	 * 
	 * } }
	 * 
	 */

	/*
	 * @Test public void testAdd() { user = new User();
	 * user.setFirstName("akalanka"); user.setLastName("gamage");
	 * user.setEmail("ak@gmail.com"); user.setContactNumber("23566");
	 * user.setRole("USER"); user.setPassword("1234");
	 * 
	 * 
	 * if(user.getRole().equals("USER")){
	 * 
	 * cart = new Cart(); cart.setUser(user);
	 * 
	 * user.setCart(cart);
	 * 
	 * }
	 * 
	 * 
	 * assertEquals("Failed to add user",true,userDao.addUser(user)); }
	 */

	/*
	 * @Test public void testGettinguser() { user =
	 * userDao.getUserByEmail("ak@gmail.com"); cart = user.getCart();
	 * 
	 * cart.setGrandTotal(555.55); cart.setCartLines(2);
	 * assertEquals("Failed to update cart",true,userDao.updateCart(cart));
	 * 
	 * }
	 * 
	 */

	/*@Test
	public void addAddress() {

		user = new User();
		user.setFirstName("akalanka");
		user.setLastName("gamage");
		user.setEmail("ak@gmail.com");
		user.setContactNumber("23566");
		user.setRole("USER");
		user.setPassword("1234");

		assertEquals("Failed to add user", true, userDao.addUser(user));

		address = new Address();
		address.setAddressLineOne(" no 73");
		address.setAddressLineTwo("horana");
		address.setCity("horana");
		address.setCountry("sri lanka");
		address.setPostalCode("12400");
		address.setBilling(true);

		address.setUser(user);

		assertEquals("Failed to add address", true, userDao.addAddress(address));

		address = new Address();
		address.setAddressLineOne(" no 73shipping");
		address.setAddressLineTwo("horana");
		address.setCity("horana");
		address.setCountry("sri lanka");
		address.setPostalCode("12400");
		address.setShipping(true);

		address.setUser(user);

		assertEquals("Failed to add shipping  address", true, userDao.addAddress(address));

	}*/
	
	
   /*@Test
	public void testAddmultipleaddress() {
		
		user  =userDao.getUserByEmail("ak@gmail.com");
		
		address = new Address();
		address.setAddressLineOne(" no 73shipping");
		address.setAddressLineTwo("horana");
		address.setCity("horana");
		address.setCountry("sri lanka");
		address.setPostalCode("12400");
		address.setShipping(true);
		
		address.setUser(user);

		assertEquals("Failed to add shipping  address", true, userDao.addAddress(address));

	}
*/
	@Test
	public void testFetchingMultipleaddress() {
		
		user  = userDao.getUserByEmail("ak@gmail.com");
		
		assertEquals("Failed to fetch list of addressaddress", 2, userDao.getListOfShippingaddress(user).size());
		assertEquals("Failed to fetch list of addressaddress", "horana" , userDao.getBillingAddress(user).getCity());

		
	}
	
	
	
	
}
