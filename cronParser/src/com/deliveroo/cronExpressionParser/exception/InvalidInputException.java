package com.deliveroo.cronExpressionParser.exception;

public class InvalidInputException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidInputException(String errorMsg) {
		super(errorMsg);
	}

}
