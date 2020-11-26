package com.example.projetoRestaurante.controller.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetoRestaurante.model.Gerente;
import com.example.projetoRestaurante.model.Vendedor;
import com.example.projetoRestaurante.service.VendedorService;

@RestController
@RequestMapping(path = "/apirest/vendedores")
public class VendedorController {
	
	@Autowired
	public VendedorService service;
	
	@GetMapping
	public ResponseEntity getAll(
			@RequestParam(name = "page", defaultValue = "0", required = false) int page,
			@RequestParam(name = "page", defaultValue = "10", required = false) int size) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll(page, size));
		
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity getOne(@PathVariable("id")Long id) {
		return ResponseEntity.ok(service.findById(id));
	}
	
	@PostMapping
	public ResponseEntity save (@Valid @RequestBody Vendedor vendedor) {
		vendedor.setId(null);
		service.save(vendedor);
		return ResponseEntity.status(HttpStatus.CREATED).body(vendedor);
		
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity update (@PathVariable("id") Long id, @Valid @RequestBody Vendedor vendedor) {
		vendedor.setId(id);
		service.update(vendedor);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity delete (@PathVariable("id")Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}
	

}
