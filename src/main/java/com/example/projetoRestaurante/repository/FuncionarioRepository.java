package com.example.projetoRestaurante.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.projetoRestaurante.model.Estoque;
import com.example.projetoRestaurante.model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	@Query("SELECT func FROM Funcionario func WHERE func.cpf = :cpf or func.telefone = :telefone")
	public List<Funcionario> findBycpfortelefone (@Param("cpf")String cpf, @Param("telefone") String email);
	

}
