package com.example.projetoRestaurante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetoRestaurante.service.FuncionarioService;

@RestController
@RequestMapping(path = "/apirest/funcionarios")
public class FuncionarioController {
	@Autowired
	private FuncionarioService service;
	
	@GetMapping
	public ResponseEntity getAll(
			@RequestParam(name = "page", defaultValue = "0", required = false) int page,
			@RequestParam(name = "page", defaultValue = "10", required = false) int size) {
		
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll(page, size));
	}
	
	

}
