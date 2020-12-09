package com.example.projetoRestaurante.service;

import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.projetoRestaurante.exception.NotFoundException;
import com.example.projetoRestaurante.model.Estoque;
import com.example.projetoRestaurante.model.Gerente;
import com.example.projetoRestaurante.model.Permissao;
import com.example.projetoRestaurante.repository.GerenteRepository;


@Service
public class GerenteService {
	
	
	@Autowired
	private GerenteRepository repo;
	
	public List<Gerente> findAll (int page, int size){
		
		Pageable p = PageRequest.of(page, size);
		return repo.findAll(p).toList();
		
	}
	
	public List<Gerente> findAll (){
		return repo.findAll();
	}
	
	public Gerente findById(Long id) {
		Optional<Gerente> result = repo.findById(id);
		if(result.isEmpty()) {
			throw new NotFoundException("Funcionario não encontrado.");
		}
		return result.get();
	}
	
	public Gerente save (Gerente ge) {
		//verifica permissões
		removePermissaoNull(ge);
		try {
			ge.setSenha(new BCryptPasswordEncoder().encode(ge.getSenha()));
			return repo.save(ge);
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
	
	public Gerente update (Gerente ge) {
		Gerente obj = findById(ge.getId());
		
		//verifica permissões
		removePermissaoNull(ge);
		
		
		try {
			ge.setNome(obj.getNome());
			ge.setTelefone(obj.getTelefone());
			ge.setCpf(obj.getCpf());
			ge.setUsuario(obj.getUsuario());
			ge.setSenha(new BCryptPasswordEncoder().encode(ge.getSenha()));
			return repo.save(ge);
			
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
		Gerente obj = findById(id);
		try {
			repo.delete(obj);
		} catch (Exception e) {
			throw new RuntimeException("Falha ao deletar Gerente");
		}
	}
	
	public void removePermissaoNull(Gerente ge) {
		ge.getPermissoes().removeIf( (Permissao p) -> {
			return p.getId() == null;
		});
		if(ge.getPermissoes().isEmpty()) {
			throw new RuntimeException("Gerente deve conter no mínimo uma permissão");
		}
	}
	

}
