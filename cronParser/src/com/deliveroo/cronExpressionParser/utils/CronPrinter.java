package com.deliveroo.cronExpressionParser.utils;

import java.util.List;
import java.util.stream.Collectors;

import com.deliveroo.cronExpressionParser.constant.Constants;
import com.deliveroo.cronExpressionParser.parser.CronParserOutput;

public class CronPrinter {

	/**
	 * Printing the output onto the console
	 * 
	 * @param output
	 */
	public String print(CronParserOutput output) {
		StringBuilder sb = new StringBuilder();
		sb.append(getLine(Constants.MINUTE, output.getMinutes()));
		sb.append(getLine(Constants.HOUR, output.getHours()));
		sb.append(getLine(Constants.DAYOFMONTH, output.getDayOfMonths()));
		sb.append(getLine(Constants.MONTH, output.getMonths()));
		sb.append(getLine(Constants.DAYOFWEEK, output.getDayOfWeeks()));
		sb.append(getCommand(Constants.COMMAND, output.getCommand()));
		System.out.println(sb.toString());
		return sb.toString();
	}

	/**
	 * Creating the individual output line for datetime
	 * 
	 * @param label
	 * @param value
	 * @return
	 */
	private String getLine(String label, List<Integer> value) {
		String valueStr = value.stream().map(Object::toString).collect(Collectors.joining(" "));
		return String.format(Constants.DELIMITER, label, valueStr, Constants.EOL);
	}

	/**
	 * Creating the individual output line for command file
	 * 
	 * @param label
	 * @param value
	 * @return
	 */
	private String getCommand(String label, String value) {
		return String.format(Constants.DELIMITER, label, value, Constants.EOL);
	}
}
