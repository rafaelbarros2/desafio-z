package com.desafioz.entities;

import java.math.BigDecimal;

public class CarroFipe {

		private BigDecimal Valor;
		private String Marca;
		private String Modelo;
		private String AnoModelo;
		
		public BigDecimal getValor() {
			return Valor;
		}
		public void setValor(BigDecimal valor) {
			Valor = valor;
		}
		public String getMarca() {
			return Marca;
		}
		public void setMarca(String marca) {
			Marca = marca;
		}
		public String getModelo() {
			return Modelo;
		}
		public void setModelo(String modelo) {
			Modelo = modelo;
		}
		public String getAnoModelo() {
			return AnoModelo;
		}
		public void setAnoModelo(String anoModelo) {
			AnoModelo = anoModelo;
		}
}
