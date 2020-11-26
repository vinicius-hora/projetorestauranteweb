package com.example.projetoRestaurante.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.projetoRestaurante.exception.NotFoundException;
import com.example.projetoRestaurante.model.Funcionario;

import com.example.projetoRestaurante.repository.FuncionarioRepository;


@Service
public class FuncionarioService {
	
	
	@Autowired
	private FuncionarioRepository repo;
	
	public List<Funcionario> findAll (int page, int size){
		
		Pageable p = PageRequest.of(page, size);
		return repo.findAll(p).toList();
		
	}
	
	public List<Funcionario> findAll (){
		return repo.findAll();
	}
	
	public Funcionario findById(Long id) {
		Optional<Funcionario> result = repo.findById(id);
		if(result.isEmpty()) {
			throw new NotFoundException("Funcionario não encontrado.");
		}
		return result.get();
	}
	
}
