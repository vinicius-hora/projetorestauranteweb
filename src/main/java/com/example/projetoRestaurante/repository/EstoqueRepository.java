package com.example.projetoRestaurante.repository;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.projetoRestaurante.model.Estoque;
import com.example.projetoRestaurante.model.Venda;


@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
		@Query("SELECT esto FROM Estoque esto WHERE esto.item = :item OR esto.data = :data")
		public List<Estoque> findByitemordata (@Param("item")String item, @Param("data") Calendar data);
		
		public Estoque findByItem (String item);
		
		

}
