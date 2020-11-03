package com.example.projetoRestaurante.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonValueInstantiator;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Funcionario implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_funcionario")
	private Long id;
	@Column(nullable = false, length = 100)
	@NotBlank (message = "Nome Obrigatório")
	@Length(max = 100)
	private String nome;
	@Column(nullable = false, length = 14, unique = true, updatable = false)
	@CPF(message = "CPF inválido")
	private String cpf;
	@Column(nullable = false, length = 14)
	@NotBlank (message = "Telefone Obrigatório")
	@Length(min=11, max=14, message = "Telefone de ser (99)9999-9999 ou (99)99999-9999")
	private String telefone;
	@ElementCollection(fetch = FetchType.EAGER)
	@OneToMany
	@JsonIgnore
	@Valid
	private List<Vendedor> vendedor = new ArrayList<>();
	@ElementCollection(fetch = FetchType.EAGER)
	@JsonIgnore
	@OneToMany
	@Valid
	private List<Gerente> gerente = new ArrayList<>();
	
	
	
	public List<Gerente> getGerente() {
		return gerente;
	}
	public void setGerente(List<Gerente> gerente) {
		this.gerente = gerente;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		return result;
	}
	public Funcionario(Long id, String nome, String cpf, String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
	}
	public Funcionario() {
	
	}
	public List<Vendedor> getVendedor() {
		return vendedor;
	}
	public void setVendedor(List<Vendedor> vendedor) {
		this.vendedor = vendedor;
	}

	

}
