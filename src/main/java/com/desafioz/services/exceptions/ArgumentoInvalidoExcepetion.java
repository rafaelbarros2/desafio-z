package com.desafioz.services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ArgumentoInvalidoExcepetion extends RuntimeException {

		private static final long serialVersionUID = -1910512927242893798L;

		public ArgumentoInvalidoExcepetion(String mensagem) {
			super(mensagem);
		}
		
		public ArgumentoInvalidoExcepetion(String mensagem, Throwable causa) {
			super(mensagem, causa);
		}
}
