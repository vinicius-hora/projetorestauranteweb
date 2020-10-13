package com.example.projetoRestaurante.model;

public class Vendedor extends Funcionario  {
	private float salario;
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
	
	
	

}
