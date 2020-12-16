package com.example.projetoRestaurante.controller.api;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.projetoRestaurante.exception.Error;
import com.example.projetoRestaurante.exception.NotFoundException;
import com.example.projetoRestaurante.exception.PropertyError;
import com.example.projetoRestaurante.exception.ValidationError;



@RestControllerAdvice(annotations = RestController.class)
public class MyRestControllerAdvice {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity erroPadrao(Exception e, HttpServletRequest request) {
		Error erro = new Error(
				Calendar.getInstance(), 
				HttpStatus.BAD_REQUEST.value(), 
				HttpStatus.BAD_REQUEST.name(), 
				e.getMessage(), 
				request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
		
	}
	
	
	//excessão no java
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity erroValidacao(ConstraintViolationException e, HttpServletRequest request) {
		ValidationError erro = new ValidationError(
				Calendar.getInstance(), 
				HttpStatus.UNPROCESSABLE_ENTITY.value(), 
				HttpStatus.UNPROCESSABLE_ENTITY.name(), 
				"Erro ao validar os dados", 
				request.getRequestURI());
		for(ConstraintViolation cons : e.getConstraintViolations()) {
			PropertyError p = new PropertyError(cons.getPropertyPath().toString(), cons.getMessage());
			erro.getErrors().add(p);
			
		}
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(erro);
		
	}
	
	//excessão no JPA
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity erroValidacao(MethodArgumentNotValidException e, HttpServletRequest request) {
		ValidationError erro = new ValidationError(
				Calendar.getInstance(), 
				HttpStatus.UNPROCESSABLE_ENTITY.value(), 
				HttpStatus.UNPROCESSABLE_ENTITY.name(), 
				"Erro ao validar os dados", 
				request.getRequestURI());
		for(FieldError fe : e.getBindingResult().getFieldErrors()) {
			PropertyError p = new PropertyError(fe.getField(), fe.getDefaultMessage());
			erro.getErrors().add(p);
			
		}
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(erro);
		
	}
	
	//erro padrão not found
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity erroPadrao(NotFoundException e, HttpServletRequest request) {
		Error erro = new Error(
				Calendar.getInstance(), 
				HttpStatus.NOT_FOUND.value(), 
				HttpStatus.NOT_FOUND.name(), 
				e.getMessage(), 
				request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
		
	}

}
