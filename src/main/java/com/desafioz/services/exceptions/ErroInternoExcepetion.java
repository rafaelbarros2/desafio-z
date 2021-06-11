package com.desafioz.services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class ErroInternoExcepetion extends RuntimeException {

		private static final long serialVersionUID = -1910512927242893798L;

		public ErroInternoExcepetion(String mensagem) {
			super(mensagem);
		}
		
		public ErroInternoExcepetion(String mensagem, Throwable causa) {
			super(mensagem, causa);
		}
}
