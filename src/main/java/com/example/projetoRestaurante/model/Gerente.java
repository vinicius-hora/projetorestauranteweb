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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.example.projetoRestaurante.anotation.SenhaValidation;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Gerente extends Funcionario{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(nullable = false)
	@NotBlank(message = "usuário deve ser preenchido")
	@Length(max = 20, message = "Usuário deve ter no máximo 20 caracteres")
	private String usuario;
	@Column(nullable = false)
	//@SenhaValidation(messege = "A senha deve contrar números, letras maiusculas e minusculas")
	@Length(min = 10, message = "Senha deve ter no mínimo 10 caracteres")
	private String senha;
	@ElementCollection(fetch = FetchType.EAGER)
	@OneToMany(mappedBy = "gerente")
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
	
	public Gerente(@NotBlank(message = "usuário deve ser preenchido") @Length(max = 20, message = "Usuário deve ter no máximo 20 caracteres") String usuario, @Length(min = 10, message = "Senha deve ter no mínimo 10 caracteres") String senha) {
		super();
		this.usuario = usuario;
		this.senha = senha;
	}
	public Gerente() {
		// TODO Auto-generated constructor stub
	}
	public Gerente(Long id, String nome, String cpf, String telefone) {
		super(id, nome, cpf, telefone);
		// TODO Auto-generated constructor stub
	}
	
	public List <Estoque> getEstoque() {
		return estoque;
	}
	public void setEstoque(List <Estoque> estoque) {
		this.estoque = estoque;
	}

	
	
	

}
