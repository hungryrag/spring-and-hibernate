package com.luv2code.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator 
	implements ConstraintValidator<CourseCode, String> {

	private String[] coursePrefixes;
	
	@Override
	public void initialize(CourseCode courseCode) {
		coursePrefixes = courseCode.value();
	}
	
	@Override
	public boolean isValid(String code, 
			ConstraintValidatorContext theConstraintValidatorContext) {
		
		boolean result = false;
		
		if (code != null) {
			//
			// loop through course prefixes
			//
			// check to see if code matches any of the course prefix
			
			for(String prefix:coursePrefixes) {
				
				if (code.startsWith(prefix)) {
					result = code.startsWith(prefix);
					break;
				}
			}
				
		}
		else
			result = true;
		
		return result;
	}
	
	
}
