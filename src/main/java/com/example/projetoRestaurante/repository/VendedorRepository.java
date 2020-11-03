package com.example.projetoRestaurante.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.example.projetoRestaurante.model.Vendedor;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Long> {
	//@Query("select  ven.id_funcionario, ven.salario, func.cpf, func.nome from vendedor as ven join funcionario as func on ven.id_funcionario = func.id_funcionario where cpf = :cpf")
	//public List<Vendedor> findByVendedorByFuncionario(@Param("vendedorid") String cpf);
	
	
	
	
	
	

}
