package com.example.projetoRestaurante.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projetoRestaurante.model.Gerente;

@Repository
public interface GerenteRepository extends JpaRepository<Gerente, Long> {
	
	public Gerente findByNome (String Nome);

	public Gerente findByUsuario(String usuario);

}
