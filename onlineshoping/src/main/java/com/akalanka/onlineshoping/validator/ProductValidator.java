package com.akalanka.onlineshoping.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.akalanka.shopingbackend.dto.Products;

public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Products.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		
		Products product  = (Products) target;
		
		//Checking whether a file has been selected 
		if(product.getFile() == null || 
				product.getFile().getOriginalFilename().equals("")) {
			
			errors.rejectValue("file", null,"Please select an image file to upload!");
			return;
		}
			
		if(!(product.getFile().getContentType().equals("image/jpg") || 
				product.getFile().getContentType().equals("image/png") ||
				product.getFile().getContentType().equals("image/gif") ||
				product.getFile().getContentType().equals("image/jpeg")
					) ) {
			
			errors.rejectValue("file", null, "please choose only image files for upload!");
			return;
		}
	}

}
