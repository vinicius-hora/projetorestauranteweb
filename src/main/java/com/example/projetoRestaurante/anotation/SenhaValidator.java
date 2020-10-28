package com.example.projetoRestaurante.anotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SenhaValidator implements ConstraintValidator<SenhaValidation, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value==null) return false;
		if(value.contains(" ")) return false;
		return value.matches("[a-zA-Z_0-9]");
	}	
}
