package com.deliveroo.cronExpressionParser.utils;

import com.deliveroo.cronExpressionParser.constant.Constants;
import com.deliveroo.cronExpressionParser.exception.InvalidInputException;
import com.deliveroo.cronExpressionParser.exception.RangeOutOfBoundException;
import com.deliveroo.cronExpressionParser.model.Range;

public class CronInputValidator {

	/**
	 * Checks if the value of the string is an integer
	 * 
	 * @param s
	 * @return
	 */
	public boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
		return true;
	}

	/**
	 * Validate if the number is within the range.
	 * 
	 * @param input
	 * @param range
	 * @return
	 * @throws RangeOutOfBoundException
	 */
	public boolean validateNumber(String input, Range range) throws RangeOutOfBoundException {
		int value = Integer.parseInt(input);
		if (!range.isValid(value)) {
			throw new RangeOutOfBoundException(Constants.OUTOFRANGE);
		}
		return true;
	}

	/**
	 * Validate input containing asterisk
	 * 
	 * @param input
	 * @return
	 */
	public boolean validateAsterisk(String input) {
		if (!input.equals(Constants.ASTERISK))
			throw new InvalidInputException(Constants.INVALIDINPUT);
		return true;
	}

	/**
	 * Validate input containing dash
	 * 
	 * @param input
	 * @param range
	 * @return
	 * @throws RangeOutOfBoundException
	 */
	public boolean validateDash(String input, Range range) throws RangeOutOfBoundException {
		String inputArr[] = input.split(Constants.DASH);
		if (inputArr.length != 2)
			throw new InvalidInputException(Constants.INVALIDINPUT);
		for (String str : inputArr) {
			if (!isInteger(str))
				throw new InvalidInputException(Constants.INVALIDINPUT);
			else if (!range.isValid(Integer.parseInt(str)))
				throw new RangeOutOfBoundException(Constants.OUTOFRANGE);
		}
		return true;
	}

	/**
	 * Validate input containing comma
	 * 
	 * @param input
	 * @param range
	 * @return
	 * @throws RangeOutOfBoundException
	 */
	public boolean validateComma(String input, Range range) throws RangeOutOfBoundException {
		String inputArr[] = input.split(Constants.COMMA);
		if (inputArr.length != 2)
			throw new InvalidInputException(Constants.INVALIDINPUT);
		for (String str : inputArr) {
			if (!isInteger(str))
				throw new InvalidInputException(Constants.INVALIDINPUT);
			else if (!range.isValid(Integer.parseInt(str)))
				throw new RangeOutOfBoundException(Constants.OUTOFRANGE);
		}
		return true;
	}

	/**
	 * Validate input starting with slash
	 * 
	 * @param input
	 * @param range
	 * @return
	 */
	public boolean validateSlash(String input, Range range) {
		String subString = input.substring(input.indexOf(Constants.SLASH) + 2);
		if (!isInteger(subString)) {
			throw new InvalidInputException(Constants.INVALIDINPUT);
		}
		return true;
	}

}
