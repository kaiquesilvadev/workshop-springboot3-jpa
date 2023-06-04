package com.example.demo.services.exceptions;

public class ResoucerNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public ResoucerNotFoundException(Object id) {
		super("recurso não encontrado .id "+ id);
	}
}
