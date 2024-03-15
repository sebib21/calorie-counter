package com.sebaba.caloriecounter.core.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MealDateValidator.class)
public @interface MealDateValidation {

	String message() default "Meal date must be today or within one day in the past or future!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
	
}