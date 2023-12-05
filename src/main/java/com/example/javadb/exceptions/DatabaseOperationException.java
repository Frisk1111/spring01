package com.example.javadb.exceptions;

public class DatabaseOperationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DatabaseOperationException() {
	}

	public DatabaseOperationException(String message) {
		super(message);
	}

	public DatabaseOperationException(Throwable cause) {
		super(cause);
	}

	public DatabaseOperationException(String message, Throwable cause) {
		super(message, cause);
	}

	public DatabaseOperationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
