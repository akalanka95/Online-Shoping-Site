package com.akalanka.onlineshoping.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.akalanka.onlineshopping.model.UserModel;
import com.akalanka.shopingbackend.dao.UserDao;
import com.akalanka.shopingbackend.dto.User;

@ControllerAdvice
public class GlobalController {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private UserDao userDao; 
	
	private UserModel userModel = null;
	
	@ModelAttribute("userModel")
	public UserModel getUserModel() {
		
		if(session.getAttribute("userModel") == null) {
			
			
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			
			User user = userDao.getUserByEmail(authentication.getName());
			if( user != null) {
				
				userModel = new UserModel();
				userModel.setId(user.getId());
				userModel.setEmail(user.getEmail());
				userModel.setRole(user.getRole());
				userModel.setFullName(user.getFirstName() + " " + user.getLastName());;
				
				if(userModel.getRole().equals("USER")) {
					userModel.setCart(user.getCart());
					
				}
				
				session.setAttribute("userModel", userModel);
				
				return userModel;
			}
		}
		
		return (UserModel) session.getAttribute("userModel");
	}
	
	
	
}
