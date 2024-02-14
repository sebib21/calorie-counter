package com.sebaba.caloriecounter.core.validation;

import java.util.regex.Pattern;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NamingConstraintValidator implements ConstraintValidator<NamingValidation, String> {

	private int minLength;
	private int maxLength;
	
    private static final Pattern FORBIDDEN_CHAR_PATTERN = Pattern.compile("[<>;\\[\\]{}\\\\]");
    private static final Pattern MULTIPLE_WHITESPACES_PATTERN = Pattern.compile("\\s{2,}");

    
	@Override
	public void initialize(NamingValidation constraintAnnotation) {
		this.minLength = constraintAnnotation.minLength();
		this.maxLength = constraintAnnotation.maxLength();
	}

	@Override
	public boolean isValid(String nameValue, ConstraintValidatorContext context) {

		if(nameValue == null || nameValue.trim().isEmpty()) {
			return false;
		}else if (nameValue.trim().length() < minLength || nameValue.length() > maxLength) {
			return false;
		}else if (FORBIDDEN_CHAR_PATTERN.matcher(nameValue).find()) {
			return false;
		}else if (MULTIPLE_WHITESPACES_PATTERN.matcher(nameValue).find()) {
			return false;
		}
		
		return true;
	}

}