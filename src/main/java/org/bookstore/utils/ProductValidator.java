package org.bookstore.utils;

import org.bookstore.models.Product;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
public class ProductValidator implements Validator{
	
	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,
				"title", "field.required");
		System.out.println("VALIDATION ERRRRRRROUUUUUUU");
	}

	@Override
	public boolean supports(Class<?> clazz) {
	return Product.class.isAssignableFrom(clazz);
	}



}
