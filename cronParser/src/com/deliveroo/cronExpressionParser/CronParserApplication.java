package com.deliveroo.cronExpressionParser;

import com.deliveroo.cronExpressionParser.constant.Constants;
import com.deliveroo.cronExpressionParser.converter.CronConverter;
import com.deliveroo.cronExpressionParser.converter.CronExpression;
import com.deliveroo.cronExpressionParser.exception.InvalidInputException;
import com.deliveroo.cronExpressionParser.exception.RangeOutOfBoundException;
import com.deliveroo.cronExpressionParser.parser.CronParser;
import com.deliveroo.cronExpressionParser.parser.CronParserOutput;
import com.deliveroo.cronExpressionParser.utils.CronPrinter;

/**
 * @author anirban
 *
 */
public class CronParserApplication {

	/**
	 * Main Application Starting Function
	 * 
	 * @param args
	 * @throws InvalidInputException
	 * @throws RangeOutOfBoundException
	 */
	public static void main(String[] args) throws InvalidInputException, RangeOutOfBoundException {
		
		if(args == null || args.length != 1) {
			throw new InvalidInputException(Constants.INVALIDINPUT);
		}
		
		String input = args[0]; //capture input passed from command line
		CronParser parser = new CronParser();
		CronExpression expression = parser.parseInput(input); // parse input
		expression.validate(); // validate each entry
		
		CronConverter converter = new CronConverter();
		CronParserOutput output = converter.convertInput(expression); // convert input to valid output
		
		CronPrinter printer = new CronPrinter();
		printer.print(output); // prints output
	}

}
