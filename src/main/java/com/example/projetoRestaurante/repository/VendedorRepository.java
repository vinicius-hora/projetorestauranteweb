package com.example.projetoRestaurante.repository;




import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;


import com.example.projetoRestaurante.model.Vendedor;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Long> {
	
	public Vendedor findByVendedorNome(String Nome);
	

	

}
