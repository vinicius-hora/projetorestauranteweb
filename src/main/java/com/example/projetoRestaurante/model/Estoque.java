package com.example.projetoRestaurante.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ManyToAny;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
public class Estoque implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_estoque")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estoque other = (Estoque) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Column(nullable = false, length = 200)
	@Length(max = 200, message = "deve ter no máximo 200 caractéres")
	@NotBlank(message = "Itém é obrigatório")
	private String item;
	@Length(max = 50, message = "deve ter no máximo 50 caractéres")
	private String nota_fiscal;
	@Column(nullable = false)
	@Min(value = 0)
	private float valor;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	@NotNull(message = "Datade compra é obrigatório")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Calendar data;
	@ManyToOne
	@JsonBackReference
	private Gerente gerente;
	
	
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
	public @NotNull(message = "Datade compra é obrigatório") Calendar getData() {
		return data;
	}
	public void setData(@NotNull(message = "Datade compra é obrigatório") Calendar data) {
		this.data = data;
	}
	public Estoque(String item, String nota_fiscal, float valor, @NotNull(message = "Datade compra é obrigatório") Calendar data) {
		super();
		this.item = item;
		this.nota_fiscal = nota_fiscal;
		this.valor = valor;
		this.data = data;
	}
	public Estoque() {
		// TODO Auto-generated constructor stub
	}
	public Gerente getGerente() {
		return gerente;
	}
	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}
	
	
	

}
