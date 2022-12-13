package com.deliveroo.cronExpressionParser.model;

public class DayOfMonth extends TimeField {

	public DayOfMonth(String input) {
		super(input, new Range(1, 31));
	}
}
