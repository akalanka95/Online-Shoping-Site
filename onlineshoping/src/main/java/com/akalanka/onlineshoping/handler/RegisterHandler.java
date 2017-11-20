package com.akalanka.onlineshoping.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.akalanka.onlineshopping.model.RegisterModel;
import com.akalanka.shopingbackend.dao.UserDao;
import com.akalanka.shopingbackend.dto.Address;
import com.akalanka.shopingbackend.dto.Cart;
import com.akalanka.shopingbackend.dto.User;

@Component
public class RegisterHandler {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public RegisterModel init() {

		return new RegisterModel();
	}

	public void addUser(RegisterModel registerModel, User user) {
		registerModel.setUser(user);
	}
	
	public void addBilling(RegisterModel registerModel, Address billing) {
		registerModel.setBilling(billing);
	}
	
	
	public String validateUser(User user, MessageContext error) {
	
		String transitionValue = "success";
		
		if(!(user.getPassword().equals(user.getConfirmPassword()))) {
		
			error.addMessage(new MessageBuilder().error().source("confirmPassword").defaultText("Password does not match the confirm password").build());
			
			transitionValue ="failure";
		}
		 
		if(userDao.getUserByEmail(user.getEmail()) != null) {
			
			
			error.addMessage(new MessageBuilder().error().source("email").defaultText("Email Address is already use!").build());
			
			
			
			transitionValue ="failure";
		}
		
		return  transitionValue;
		
	}
	
	
	public String saveAll(RegisterModel model) {
		String transitionValue = "success";
		
		//fetch the user
		User user = model.getUser();
		
		if(user.getRole().equals("USER")) {
			Cart cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);
			
		}
		
		//encode the password
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		
		//save user
		userDao.addUser(user);
		
		//get Address
		
		Address billing = model.getBilling();
		
		billing.setUser(user);
		billing.setBilling(true);
		
		//save the address
		userDao.addAddress(billing);
		
		return transitionValue;
	}

}
