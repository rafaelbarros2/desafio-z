package com.desafioz.services.exceptions;

public class ResourceNotFoundExceptions  extends RuntimeException{

	
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundExceptions(String mensagem, Object id) {
		super (mensagem + id);
	}

	
	}
	
	

