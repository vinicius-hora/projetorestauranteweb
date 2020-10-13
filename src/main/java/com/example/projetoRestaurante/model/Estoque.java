package com.example.projetoRestaurante.model;

import java.io.Serializable;

public class Estoque implements Serializable{
	private static final long serialVersionUID = 1L;
	private String item;
	private String nota_fiscal;
	private float valor;
	private String data;
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getNota_fiscal() {
		return nota_fiscal;
	}
	public void setNota_fiscal(String nota_fiscal) {
		this.nota_fiscal = nota_fiscal;
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
	public Estoque(String item, String nota_fiscal, float valor, String data) {
		super();
		this.item = item;
		this.nota_fiscal = nota_fiscal;
		this.valor = valor;
		this.data = data;
	}
	
	
	

}
