package com.sebaba.caloriecounter.core.exception;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CategoryNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ErrorResponse handleCategoryNotFoundException(CategoryNotFoundException categoryNotFoundException) {
		return new ErrorResponse("Category doesn't exist!", categoryNotFoundException, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MacronutrientNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ErrorResponse handleMacronutrientNotFoundException(MacronutrientNotFoundException macronutrientNotFoundException) {
		return new ErrorResponse("Specified macronutrient doesn't exist!", macronutrientNotFoundException, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MicronutrientNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ErrorResponse handleMicronutrientNotFoundException(MicronutrientNotFoundException micronutrientNotFoundException) {
		return new ErrorResponse("Specified micronutrient doesn't exist!", micronutrientNotFoundException, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ErrorResponse handleProductNotFoundException(ProductNotFoundException productNotFoundException) {
		return new ErrorResponse("Product doesn't exist!", productNotFoundException, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(WeightGoalNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ErrorResponse handleWeightGoalNotFoundException(WeightGoalNotFoundException weightGoalNotFoundException) {
		return new ErrorResponse("Specified weight goal doesn't exist!", weightGoalNotFoundException, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PersonNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ErrorResponse handleWeightGoalNotFoundException(PersonNotFoundException personNotFoundException) {
		return new ErrorResponse("Person doesn't exist for the required operation!", personNotFoundException, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
		
		Map<String, String> validationErrorMap = new HashMap<String, String>();
		
		methodArgumentNotValidException
								.getBindingResult()
								.getAllErrors()
								.forEach(error -> {
									validationErrorMap.put(
											((FieldError)error).getField(), 
											error.getDefaultMessage()
										);
								});
		
		return new ResponseEntity<>(validationErrorMap, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorResponse handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException sqlIntegrityConstraintViolationException) {
		
		int errorCode = sqlIntegrityConstraintViolationException.getErrorCode();
		String errorMessage = "SQL Error: " + sqlIntegrityConstraintViolationException.getErrorCode();

            errorMessage += errorCode == 1062 ? " - Duplicate entry detected" :
            				errorCode == 1451 ? " - Cannot delete or update a parent row" :
            				errorCode == 1452 ? " - Cannot add or update a child row: a foreign key constraint fails" :
            				" - Unknown error message";
        
		return new ErrorResponse(errorMessage, sqlIntegrityConstraintViolationException, HttpStatus.BAD_REQUEST);
	}
	
}