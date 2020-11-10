package com.example.projetoRestaurante.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
public class Vendedor extends Funcionario  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(nullable = false, length = 200, updatable = true)
	private float salario;
	@JsonIgnore
	@OneToMany(mappedBy = "vendedor")
	@ElementCollection(fetch = FetchType.EAGER)
	private List <Venda> venda = new ArrayList<>();

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	

	public Vendedor(Long id, String nome, String cpf, String telefone, float salario, Funcionario funcionario) {
		super(id, nome, cpf, telefone);
		this.salario = salario;
	}



	public Vendedor() {
		
	}

	public List <Venda> getVenda() {
		return venda;
	}

	public void setVenda(List <Venda> venda) {
		this.venda = venda;
	}
	
	
	

}
