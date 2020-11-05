package com.example.projetoRestaurante.repository;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.projetoRestaurante.model.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {
	
	@Query("SELECT ven FROM Venda ven WHERE ven.item = :item OR ven.data = :data")
	public List<Venda> findByitemordata (@Param("item")String item, @Param("data") Calendar data);
	
	public Venda findByItem (String item);
	
	
	

}
