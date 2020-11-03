package com.example.projetoRestaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projetoRestaurante.model.Estoque;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
		
	

}
