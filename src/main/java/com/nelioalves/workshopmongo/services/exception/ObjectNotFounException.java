/*Essa classe representa uma exceção personalizada, lançada quando o objeto solicitado não é encontrado no sistema.*/
package com.nelioalves.workshopmongo.services.exception;

public class ObjectNotFounException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ObjectNotFounException(String msg) {
		super(msg);
	}

}
