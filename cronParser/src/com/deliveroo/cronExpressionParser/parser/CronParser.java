package com.deliveroo.cronExpressionParser.parser;

import java.util.ArrayList;
import java.util.List;

import com.deliveroo.cronExpressionParser.constant.Constants;
import com.deliveroo.cronExpressionParser.converter.CronExpression;
import com.deliveroo.cronExpressionParser.exception.InvalidInputException;
import com.deliveroo.cronExpressionParser.model.Command;
import com.deliveroo.cronExpressionParser.model.DayOfMonth;
import com.deliveroo.cronExpressionParser.model.DayOfWeek;
import com.deliveroo.cronExpressionParser.model.Hour;
import com.deliveroo.cronExpressionParser.model.Minute;
import com.deliveroo.cronExpressionParser.model.Month;
import com.deliveroo.cronExpressionParser.model.TimeField;

public class CronParser {

	/**
	 * Validate the user input
	 * 
	 * @param inputArr
	 */
	public void validate(String[] inputArr) {
		if (inputArr.length != 6)
			throw new InvalidInputException(Constants.INVALIDINPUT);
	}

	/**
	 * Parse user input
	 * 
	 * @param input
	 * @return
	 */
	public CronExpression parseInput(String input) {
		String[] inputArr = input.split(" ");
		validate(inputArr);

		CronExpression expression = new CronExpression();
		expression.setMinute(new Minute(inputArr[0]));
		expression.setHour(new Hour(inputArr[1]));
		expression.setDayOfMonth(new DayOfMonth(inputArr[2]));
		expression.setMonth(new Month(inputArr[3]));
		expression.setDayOfWeek(new DayOfWeek(inputArr[4]));
		expression.setCommand(new Command(inputArr[5]));

		return expression;
	}

	/**
	 * Build the final result
	 * 
	 * @param timeField
	 * @return
	 */
	public List<Integer> buildOutput(TimeField timeField) {
		List<Integer> result = new ArrayList<>();
		int start = timeField.getRange().getStart();
		int end = timeField.getRange().getEnd();
		String input = timeField.getInput();

		if (input.equals(Constants.ASTERISK)) {
			handleAsterisk(result, start, end);
		} else if (input.contains(Constants.SLASH)) {
			handleSlash(result, input, start, end);
		} else if (input.contains(Constants.COMMA)) {
			handleComma(result, input);
		} else if (input.contains(Constants.DASH)) {
			handleDash(result, input);
		} else if (input.matches(Constants.NUMERIC)) {
			result.add(Integer.parseInt(input));
		}

		return result;
	}

	/**
	 * Build input containing asterisk
	 * 
	 * @param result
	 * @param start
	 * @param end
	 */
	private void handleAsterisk(List<Integer> result, int start, int end) {
		for (int i = start; i <= end; i++) {
			result.add(i);
		}
	}

	/**
	 * Build input containing slash
	 * 
	 * @param result
	 * @param input
	 * @param start
	 * @param end
	 */
	private void handleSlash(List<Integer> result, String input, int start, int end) {
		String subString = input.substring(input.indexOf(Constants.SLASH) + 2);
		int range = Integer.parseInt(subString);
		int count = ((end - start) / range) + 1;
		for (int i = 0; i < count; i++) {
			result.add(i * range);
		}
	}

	/**
	 * Build input containing comma
	 * 
	 * @param result
	 * @param input
	 */
	private void handleComma(List<Integer> result, String input) {
		String[] splitArr = input.split(Constants.COMMA);
		for (int i = 0; i < splitArr.length; i++) {
			result.add(Integer.parseInt(splitArr[i]));
		}
	}

	/**
	 * Build input containing dash
	 * 
	 * @param result
	 * @param input
	 */
	private void handleDash(List<Integer> result, String input) {
		String[] splitArr = input.split(Constants.DASH);
		int rangeLow = Integer.parseInt(splitArr[0]);
		int rangeHigh = Integer.parseInt(splitArr[1]);
		for (int i = rangeLow; i <= rangeHigh; i++) {
			result.add(i);
		}
	}

}
