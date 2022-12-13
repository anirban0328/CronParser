package com.deliveroo.cronExpressionParser.model;

public class DayOfWeek extends TimeField {

	public DayOfWeek(String input) {
		super(input, new Range(1, 7));
	}
}
