package com.example.projetoRestaurante.service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.projetoRestaurante.exception.NotFoundException;
import com.example.projetoRestaurante.model.Estoque;

import com.example.projetoRestaurante.repository.EstoqueRepository;



@Service
public class EstoqueService {
	
	
	private static final @NotNull(message = "Datade compra é obrigatório") Calendar Data = null;
	@Autowired
	private EstoqueRepository repo;
	
	public List<Estoque> findAll (int page, int size){
		
		Pageable p = PageRequest.of(page, size);
		return repo.findAll(p).toList();
		
	}
	
	public List<Estoque> findAll (){
		return repo.findAll();
	}
	
	public Estoque findById(Long id) {
		Optional<Estoque> result = repo.findById(id);
		if(result.isEmpty()) {
			throw new NotFoundException("Estoque não encontrado.");
		}
		return result.get();
	}
	
	public Estoque save (Estoque es) {
		try {
			es.setData(Calendar.getInstance());
			return repo.save(es);
		}
		catch (Exception e) {
			throw new RuntimeException("Falha ao salvar Estoque.");
		}
	}
	
	public void delete (Long id) {
		Estoque obj = findById(id);
		try {
			repo.delete(obj);
		} catch (Exception e) {
			throw new RuntimeException("Falha ao deletar Estoque");
		}
	}
	

}
