package com.deliveroo.cronExpressionParser.converter;

import com.deliveroo.cronExpressionParser.parser.CronParser;
import com.deliveroo.cronExpressionParser.parser.CronParserOutput;

public class CronConverter {

	/**
	 * Converts inputs to desired output
	 * 
	 * @param input
	 * @return
	 */
	public CronParserOutput convertInput(CronExpression input) {
		CronParserOutput output = new CronParserOutput();
		CronParser parser = new CronParser();
		output.setMinutes(parser.buildOutput(input.getMinute()));
		output.setHours(parser.buildOutput(input.getHour()));
		output.setDayOfMonths(parser.buildOutput(input.getDayOfMonth()));
		output.setMonths(parser.buildOutput(input.getMonth()));
		output.setDayOfWeeks(parser.buildOutput(input.getDayOfWeek()));
		output.setCommand(input.getCommand().toString());
		return output;
	}

}
