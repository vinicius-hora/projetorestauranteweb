package com.example.projetoRestaurante.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.projetoRestaurante.model.Gerente;

@Repository
public interface GerenteRepository extends JpaRepository<Gerente, Long> {

	

}
