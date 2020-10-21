package com.example.projetoRestaurante.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
public class Vendedor extends Funcionario  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(nullable = false, length = 200, updatable = true)
	private float salario;
	@JsonBackReference
	@OneToMany(mappedBy = "venda")
	@JoinColumn(nullable = false, name = "vendedor_id")
	private List <Venda> venda = new ArrayList<>();
	@ManyToAny(metaColumn = @Column)
	@JsonManagedReference
	private Funcionario funcionario;

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Vendedor(Long id, String nome, String cpf, String telefone, float salario, Funcionario funcionario) {
		super(id, nome, cpf, telefone);
		this.salario = salario;
		this.funcionario = funcionario;
	}

	public List <Venda> getVenda() {
		return venda;
	}

	public void setVenda(List <Venda> venda) {
		this.venda = venda;
	}
	
	
	

}
