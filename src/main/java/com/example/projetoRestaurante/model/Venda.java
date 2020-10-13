package com.example.projetoRestaurante.model;

import java.io.Serializable;

public class Venda implements Serializable{
	private static final long serialVersionUID = 1L;
	private String item;
	private float valor;
	private String data;
	
	
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Venda(String item, float valor, String data) {
		super();
		this.item = item;
		this.valor = valor;
		this.data = data;
	}

}