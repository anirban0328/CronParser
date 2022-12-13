package com.deliveroo.cronExpressionParser.model;

import com.deliveroo.cronExpressionParser.constant.Constants;
import com.deliveroo.cronExpressionParser.exception.InvalidInputException;
import com.deliveroo.cronExpressionParser.exception.RangeOutOfBoundException;
import com.deliveroo.cronExpressionParser.utils.CronInputValidator;

public abstract class TimeField {
	private String input;
	private Range range;

	TimeField(String input) {
		this.input = input;
	}

	TimeField(String input, Range range) {
		this.input = input;
		this.range = range;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public Range getRange() {
		return range;
	}

	public void setRange(Range range) {
		this.range = range;
	}

	/**
	 * Validate the input
	 * 
	 * @throws InvalidInputException
	 * @throws RangeOutOfBoundException
	 */
	public void validate() throws InvalidInputException, RangeOutOfBoundException {
		CronInputValidator validator = new CronInputValidator();
		if (validator.isInteger(input)) {
			validator.validateNumber(input, range);
		} else if (input.length() == 1) {
			validator.validateAsterisk(input);
		} else if (input.contains(Constants.DASH)) {
			validator.validateDash(input, range);
		} else if (input.contains(Constants.COMMA)) {
			validator.validateComma(input, range);
		} else if (input.contains(Constants.SLASH)) {
			validator.validateSlash(input, range);
		} else {
			throw new InvalidInputException(Constants.INVALIDINPUT);
		}
	}

}
