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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
public class Gerente extends Funcionario{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(nullable = false, length = 40, unique = true)
	private String usuario;
	@Column(nullable = false, length = 10)
	private String senha;
	@Embedded
	@JsonManagedReference
	private Funcionario funcionario;
	@JsonBackReference
	@OneToMany(mappedBy = "estoque")
	@JoinColumn(nullable = false, name = "gerente_id")
	private List <Estoque> estoque = new ArrayList<>();
	
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public Gerente(String usuario, String senha, Funcionario funcionario) {
		super();
		this.usuario = usuario;
		this.senha = senha;
		this.funcionario = funcionario;
	}
	public List <Estoque> getEstoque() {
		return estoque;
	}
	public void setEstoque(List <Estoque> estoque) {
		this.estoque = estoque;
	}

	
	
	

}
