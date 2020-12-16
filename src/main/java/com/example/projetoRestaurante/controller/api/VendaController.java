package com.example.projetoRestaurante.controller.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetoRestaurante.model.Venda;
import com.example.projetoRestaurante.service.VendaService;

@RestController
@RequestMapping(path = "/apirest/vendas")
public class VendaController {
	
	@Autowired
	public VendaService service;
	
	@GetMapping
	public ResponseEntity getAll(
			@RequestParam(name = "page", defaultValue = "0", required = false) int page,
			@RequestParam(name = "page", defaultValue = "10", required = false) int size){
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll(page, size));
		
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity getOne(@PathVariable("id")Long id) {
		return ResponseEntity.ok(service.findById(id));
	}
	
	@PostMapping
	public ResponseEntity save (@Valid @RequestBody Venda venda) {
		venda.setId(null);
		service.save(venda);
		return ResponseEntity.status(HttpStatus.CREATED).body(venda);
		
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity delete (@PathVariable("id")Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}
	
	
	
	
	

}
