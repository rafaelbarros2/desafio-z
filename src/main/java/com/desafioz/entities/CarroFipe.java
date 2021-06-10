package com.desafioz.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CarroFipe {

		@JsonProperty("Valor")
		private String valor;
		
		@JsonProperty("Marca")
		private String marca;
		
		@JsonProperty("Modelo")
		private String modelo;
		
		@JsonProperty("AnoModelo")
		private int anoModelo;
		
		public String getValor() {
			return valor;
		}
		public void setValor(String valor) {
			this.valor = valor;
		}
		public String getMarca() {
			return marca;
		}
		public void setMarca(String marca) {
			this.marca = marca;
		}
		public String getModelo() {
			return modelo;
		}
		public void setModelo(String modelo) {
			this.modelo = modelo;
		}
		public int getAnoModelo() {
			return anoModelo;
		}
		public void setAnoModelo(int anoModelo) {
			this.anoModelo = anoModelo;
		}
}
