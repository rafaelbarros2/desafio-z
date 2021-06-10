package com.desafioz.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "tb_car")
public class Cars implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String marca;
	private int codigoMarca;
	private String modeloVeiculo;
	private int codigoModelo;
	private String anoVeiculo;
	
	private String valor; 
	private String rodizio;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "client_id")
	private User client;

	public Cars() {
	}

	public Cars(Long id, Instant moment, User client) {
		super();
		this.id = id;
		this.moment = moment;
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	public String getAnoVeiculo() {
		return anoVeiculo;
	}

	public void setAnoVeiculo(String anoVeiculo) {
		this.anoVeiculo = anoVeiculo;
	}

	public String getModeloVeiculo() {
		return modeloVeiculo;
	}

	public void setModeloVeiculo(String modeloVeiculo) {
		this.modeloVeiculo = modeloVeiculo;
	}
	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getCodigoMarca() {
		return codigoMarca;
	}

	public void setCodigoMarca(int codigoMarca) {
		this.codigoMarca = codigoMarca;
	}

	public int getCodigoModelo() {
		return codigoModelo;
	}

	public void setCodigoModelo(int codigoModelo) {
		this.codigoModelo = codigoModelo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}


	public void setRodizio(String rodizio) {
		this.rodizio = rodizio;
	}
	
	public String getRodizio() {
		
		if(this.getAnoVeiculo() == null)
			return rodizio;
			
		int ultimoDigito = Integer.parseInt(this.getAnoVeiculo().substring(3,4));
		if( ultimoDigito <= 1 ) {
			this.setRodizio("Segunda-feira");
		} else if (ultimoDigito <= 3 ) {
			this.setRodizio("Terça-feira");
		} else if (ultimoDigito <= 5) {
			this.setRodizio("Quarta-feira");
		} else if (ultimoDigito <= 7) {
			this.setRodizio("Quinta-feira");
		} else if (ultimoDigito <= 9) {
			this.setRodizio("Sexta-feira");
		}
		
		return rodizio;
	}

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
		Cars other = (Cars) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
