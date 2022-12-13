package com.deliveroo.cronExpressionParser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.deliveroo.cronExpressionParser.exception.InvalidInputException;
import com.deliveroo.cronExpressionParser.exception.RangeOutOfBoundException;
import com.deliveroo.cronExpressionParser.model.Month;
import com.deliveroo.cronExpressionParser.utils.CronInputValidator;

class CronInputValidatorTest {
	
	//Test if input is an integer
	@Test
	public void TestIsInteger() {
		CronInputValidator validator = new CronInputValidator();
		Boolean result = validator.isInteger("10");
		
		assertEquals(result, true);
	}
	
	//Test if input is not an integer
	@Test
	public void TestIsNotInteger() {
		CronInputValidator validator = new CronInputValidator();
		Boolean result = validator.isInteger("abc");
		
		assertEquals(result, false);
	}
	
	//Test if input is not a valid month
	@Test
	public void TestValidateMonth() throws RangeOutOfBoundException {
		CronInputValidator validator = new CronInputValidator();
		String input = "1";
		Month month = new Month(input);
		Boolean result = validator.validateNumber(input, month.getRange());
		
		assertEquals(result, true);
	}
	
	//Test if input is in valid range
	@Test
	public void TestValidateMonthRange() throws RangeOutOfBoundException {
		CronInputValidator validator = new CronInputValidator();
		String input = "13";
		Month month = new Month(input);
		
		assertThrows(RangeOutOfBoundException.class, () -> {
			validator.validateNumber(input, month.getRange());
		});
	}
	
	//Test if input is a valid Asterisk
	@Test
	public void TestValidateAsterisk() throws InvalidInputException {
		CronInputValidator validator = new CronInputValidator();
		String input = "*";
		Boolean result = validator.validateAsterisk(input);
		
		assertEquals(result, true);
	}
	
	//Test if input is not a valid Asterisk
	@Test
	public void TestValidateAsterisk1() throws InvalidInputException {
		CronInputValidator validator = new CronInputValidator();
		String input = "**";
		
		assertThrows(InvalidInputException.class, () -> {
			validator.validateAsterisk(input);
		});
	}
	
	//Test if input has valid dash format
	@Test
	public void TestValidateDash() throws RangeOutOfBoundException {
		CronInputValidator validator = new CronInputValidator();
		String input = "3-7";
		Month month = new Month(input);
		Boolean result = validator.validateDash(input, month.getRange());
		
		assertEquals(result, true);
	}
	
	//Test if input does not have a valid range with dash
	@Test
	public void TestValidateDashRange() throws RangeOutOfBoundException {
		CronInputValidator validator = new CronInputValidator();
		String input = "3-13";
		Month month = new Month(input);
		
		assertThrows(RangeOutOfBoundException.class, () -> {
			validator.validateDash(input, month.getRange());
		});
	}
	
	//Test if input does not have a valid dash format
	@Test
	public void TestValidateDashInvalid() throws InvalidInputException {
		CronInputValidator validator = new CronInputValidator();
		String input = "-13";
		Month month = new Month(input);
		
		assertThrows(InvalidInputException.class, () -> {
			validator.validateDash(input, month.getRange());
		});
	}
	
	//Test if input has valid comma format
	@Test
	public void TestValidateComma() throws RangeOutOfBoundException {
		CronInputValidator validator = new CronInputValidator();
		String input = "4,9";
		Month month = new Month(input);
		Boolean result = validator.validateComma(input, month.getRange());
		
		assertEquals(result, true);
	}
	
	//Test if input does not have a valid range with comma
	@Test
	public void TestValidateCommaRange() throws RangeOutOfBoundException {
		CronInputValidator validator = new CronInputValidator();
		String input = "4,16";
		Month month = new Month(input);
		
		assertThrows(RangeOutOfBoundException.class, () -> {
			validator.validateComma(input, month.getRange());
		});
	}
	
	//Test if input does not have a valid comma format
	@Test
	public void TestValidateCommaInvalid() throws InvalidInputException {
		CronInputValidator validator = new CronInputValidator();
		String input = "4,";
		Month month = new Month(input);
		
		assertThrows(InvalidInputException.class, () -> {
			validator.validateComma(input, month.getRange());
		});
	}
	
	//Test if input has valid slash format
	@Test
	public void TestValidateSlash() throws RangeOutOfBoundException {
		CronInputValidator validator = new CronInputValidator();
		String input = "*/10";
		Month month = new Month(input);
		Boolean result = validator.validateSlash(input, month.getRange());
		
		assertEquals(result, true);
	}
	
	//Test if input does not have a valid number after */
	@Test
	public void TestValidateSlashInvalid() throws InvalidInputException {
		CronInputValidator validator = new CronInputValidator();
		String input = "*/ab";
		Month month = new Month(input);
		
		assertThrows(InvalidInputException.class, () -> {
			validator.validateSlash(input, month.getRange());
		});
	}
	
	//Test if input does not have a valid slash format
	/**
	 * @throws InvalidInputException
	 */
	@Test
	public void TestValidateSlashInvalid1() throws InvalidInputException {
		CronInputValidator validator = new CronInputValidator();
		String input = "*1/0";
		Month month = new Month(input);
		
		assertThrows(InvalidInputException.class, () -> {
			validator.validateSlash(input, month.getRange());
		});
	}

}
