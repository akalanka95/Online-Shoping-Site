package com.akalanka.shopingbackend.dao;

import java.util.List;

import com.akalanka.shopingbackend.dto.Address;
import com.akalanka.shopingbackend.dto.Cart;
import com.akalanka.shopingbackend.dto.User;

public interface UserDao {

	boolean addUser(User user);
	User getUserByEmail(String email);
	
	boolean addAddress(Address address);
	Address getBillingAddress(User user);
	List<Address> getListOfShippingaddress(User user);
	
	
	
}
