package com.deliveroo.cronExpressionParser.exception;

public class RangeOutOfBoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public RangeOutOfBoundException(String errorMsg) {
		super(errorMsg);
	}

}
