package com.example.projetoRestaurante.anotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = SenhaValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SenhaValidation {
	String messege() default "Senha deve ter números e letras maiusculas e minusculas";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
