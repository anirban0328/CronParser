package com.deliveroo.cronExpressionParser.model;

public class Month extends TimeField {

	public Month(String input) {
		super(input, new Range(1, 12));
	}

}
