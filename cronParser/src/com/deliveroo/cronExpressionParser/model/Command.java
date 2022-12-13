package com.deliveroo.cronExpressionParser.model;

public class Command extends TimeField {
	public Command(String command) {
		super(command);
	}

	@Override
	public String toString() {
		return super.getInput();
	}

}
