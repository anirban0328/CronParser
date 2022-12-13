package com.deliveroo.cronExpressionParser.model;

public class Hour extends TimeField {

	public Hour(String input) {
		super(input, new Range(0, 23));
	}

}
