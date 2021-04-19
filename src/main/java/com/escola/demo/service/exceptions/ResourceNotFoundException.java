package com.escola.demo.service.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Object id) {
		// Esse construtor recebe como parâmetro o id
		// do objeto que foi procurado, porém não encotrado.
		super("Resource not found. id: " + id);
	}

}
