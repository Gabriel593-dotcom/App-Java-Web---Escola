package com.escola.demo.controller.exceptions;

import java.io.Serializable;
import java.time.Instant;

public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;

//Quando há um erro na requisição realizada, por
//padrão o spring retorna uma resposta com essa estrutura: 
//	{
//	    "timestamp": "2021-03-02T00:22:05.461+00:00",
//	    "status": 500,
//	    "error": "Internal Server Error",
//	    "message": "",
//	    "path": "/users/982"
//	}

//Então para fazer um tratamento manual das excessões e
// retornar resposta similares a essa estrutura, vamos utilizar
// essa classe.

	private Instant timeStamp;
	private Integer status;
	private String error;
	private String message;
	private String path;

	public StandardError() {
	}

	public StandardError(Instant timeStamp, Integer status, String error, String message, String path) {
		this.timeStamp = timeStamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}

	public Instant getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Instant timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
