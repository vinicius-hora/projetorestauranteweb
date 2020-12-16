package com.example.projetoRestaurante.service;

import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.projetoRestaurante.exception.NotFoundException;

import com.example.projetoRestaurante.model.Vendedor;

import com.example.projetoRestaurante.repository.VendedorRepository;


@Service
public class VendedorService {
	
	
	@Autowired
	private VendedorRepository repo;
	
	public List<Vendedor> findAll (int page, int size){
		
		Pageable p = PageRequest.of(page, size);
		return repo.findAll(p).toList();
		
	}
	
	public List<Vendedor> findAll (){
		return repo.findAll();
	}
	
	public Vendedor findById(Long id) {
		Optional<Vendedor> result = repo.findById(id);
		if(result.isEmpty()) {
			throw new NotFoundException("Funcionario não encontrado.");
		}
		return result.get();
	}
	
	public Vendedor save (Vendedor ven) {
		try {
			return repo.save(ven);
		}
		catch (Exception e) {
			Throwable t = e;
			while(t.getCause() != null) {
				t = t.getCause();
				if(t instanceof ConstraintViolationException) {
					throw((ConstraintViolationException)t);
				}
			}
			throw new RuntimeException("Falha ao atualizar atualizar dados");
		}
	}
	
	public Vendedor update (Vendedor ven) {
		Vendedor obj = findById(ven.getId());
		
		
		try {
			ven.setNome(obj.getNome());
			ven.setTelefone(obj.getTelefone());
			ven.setSalario(obj.getSalario());
			return repo.save(ven);
			
		} catch (Exception e) {
			Throwable t = e;
			while(t.getCause() != null) {
				t = t.getCause();
				if(t instanceof ConstraintViolationException) {
					throw((ConstraintViolationException)t);
				}
			}
			throw new RuntimeException("Falha ao atualizar atualizar dados");
		}
	}
	
	public void delete (Long id) {
		Vendedor obj = findById(id);
		try {
			repo.delete(obj);
		} catch (Exception e) {
			throw new RuntimeException("Falha ao deletar Gerente");
		}
	}
	

}
