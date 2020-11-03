package com.example.projetoRestaurante.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.projetoRestaurante.model.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {
	
	
	

}
