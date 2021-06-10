package com.desafioz.services.exceptions;

public class GeneralExcpetion extends RuntimeException {

		private static final long serialVersionUID = -1;

		public GeneralExcpetion(String mensagem) {
			super(mensagem);
		}
		
		public GeneralExcpetion(String mensagem, Throwable causa) {
			super(mensagem, causa);
		}
}
