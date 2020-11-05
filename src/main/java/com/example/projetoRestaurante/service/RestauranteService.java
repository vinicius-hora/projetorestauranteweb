package com.example.projetoRestaurante.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.example.projetoRestaurante.model.Funcionario;

import com.example.projetoRestaurante.repository.FuncionarioRepository;


@Service
public class RestauranteService {
	
	
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
			throw new RuntimeException("Funcionario não encontrado.");
		}
		return result.get();
	}
	
	public Funcionario save (Funcionario func) {
		try {
			return repo.save(func);
		}
		catch (Exception e) {
			throw new RuntimeException("Falha ao salvar funcionario.");
		}
	}
	
	public void delete (Long id) {
		Funcionario obj = findById(id);
		try {
			repo.delete(obj);
		} catch (Exception e) {
			throw new RuntimeException("Falha ao deletar funcionario");
		}
	}
	

}
