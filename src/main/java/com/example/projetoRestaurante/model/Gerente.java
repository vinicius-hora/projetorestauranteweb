package com.example.projetoRestaurante.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	@Column(nullable = false, length = 40, unique = true)
	@NotBlank(message = "usuário deve ser preenchido")
	@Length(max = 20, message = "Usuário deve ter no máximo 20 caracteres")
	private String usuario;
	@Column(nullable = false, length = 10)
	@SenhaValidation(messege = "A senha deve contrar números, letras maiusculas e minusculas")
	@Length(min = 10, message = "Senha deve ter no mínimo 10 caracteres")
	private String senha;
	@Embedded
	@OneToOne
	@Valid
	@NotNull(message = "funcionário obrigatório")
	private Funcionario funcionario;
	@JsonBackReference
	@OneToMany(mappedBy = "gerente")
	@Valid
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
