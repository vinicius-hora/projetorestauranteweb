package com.example.projetoRestaurante.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.example.projetoRestaurante.model.Venda;

import com.example.projetoRestaurante.repository.VendaRepository;



@Service
public class VendaService {
	
	
	@Autowired
	private VendaRepository repo;
	
	public List<Venda> findAll (int page, int size){
		
		Pageable p = PageRequest.of(page, size);
		return repo.findAll(p).toList();
		
	}
	
	public List<Venda> findAll (){
		return repo.findAll();
	}
	
	public Venda findById(Long id) {
		Optional<Venda> result = repo.findById(id);
		if(result.isEmpty()) {
			throw new RuntimeException("Venda não encontrada.");
		}
		return result.get();
	}
	
	public Venda save (Venda ven) {
		try {
			return repo.save(ven);
		}
		catch (Exception e) {
			throw new RuntimeException("Falha ao salvar Venda.");
		}
	}
	
	public void delete (Long id) {
		Venda obj = findById(id);
		try {
			repo.delete(obj);
		} catch (Exception e) {
			throw new RuntimeException("Falha ao deletar Venda");
		}
	}
	

}
