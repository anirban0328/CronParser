package com.deliveroo.cronExpressionParser.model;

public class Minute extends TimeField {

	public Minute(String input) {
		super(input, new Range(0, 59));
	}

}
