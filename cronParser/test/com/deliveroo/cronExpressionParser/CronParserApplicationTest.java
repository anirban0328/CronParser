package com.deliveroo.cronExpressionParser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.deliveroo.cronExpressionParser.exception.RangeOutOfBoundException;
import com.deliveroo.cronExpressionParser.parser.CronParser;
import com.deliveroo.cronExpressionParser.parser.CronParserOutput;
import com.deliveroo.cronExpressionParser.utils.CronPrinter;
import com.deliveroo.cronExpressionParser.converter.CronConverter;
import com.deliveroo.cronExpressionParser.converter.CronExpression;
import com.deliveroo.cronExpressionParser.exception.InvalidInputException;

/**
 * @author anirban
 *
 */
class CronParserApplicationTest {
	
	//Test Main Application
	@Test
	public void TestValidCase() {
		String[] args = new String[1];
		args[0] = "*/15 0 1,15 * 1-5 /usr/bin/find";
		
		assertDoesNotThrow(() -> {
			CronParserApplication.main(args);
		});
		
	}
	
	//Test valid case 1
	@Test
	public void TestValidCase1() {
		String[] args = new String[1];
		args[0] = "1-10 * 10 1-3 3,4 /usr/bin/find1";
		
		assertDoesNotThrow(() -> {
			CronParserApplication.main(args);
		});
		
	}
	
	//Test valid case 2
	@Test
	public void TestValidCase2() {
		String[] args = new String[1];
		args[0] = "*/30 */2 5-10 3-8 4 /usr/bin/find2";
		
		assertDoesNotThrow(() -> {
			CronParserApplication.main(args);
		});
		
	}
	
	//Test output
	@Test
	public void TestActualOutput() {
		String input = "*/15 0 1,15 * 1-5 /usr/bin/find";
		String expectedResult = "minute        0 15 30 45\n" + 
							    "hour          0\n" + 
							    "day of month  1 15\n" + 
							    "month         1 2 3 4 5 6 7 8 9 10 11 12\n" + 
							    "day of week   1 2 3 4 5\n" + 
							    "command       /usr/bin/find";
		
		CronExpression expression = new CronParser().parseInput(input);
		CronParserOutput output = new CronConverter().convertInput(expression);
		String result = new CronPrinter().print(output).trim();
		
		assertEquals(expectedResult, result);
	}
	
	//Test Empty Input
	@Test
	public void TestEmptyInput() {
		String[] args = {};
		
		assertThrows(InvalidInputException.class, () -> {
			CronParserApplication.main(args);
		});
		
	}
	
	//Test null input
	@Test
	public void TestNullInput() {
		String[] args = null;
		
		assertThrows(InvalidInputException.class, () -> {
			CronParserApplication.main(args);
		});
		
	}
	
	// Test Invalid Character
	@Test
	public void TestInvalidCharacter() {
		String[] args = {"*/15 a 1,15 * 1-5 /usr/bin/find"};
		
		assertThrows(InvalidInputException.class, () -> {
			CronParserApplication.main(args);
		});
		
	}
	
	// Test Invalid Character 1
	@Test
	public void TestInvalidCharacter1() {
		String[] args = {"*/15 0 1,15 xyz 1-5 /usr/bin/find"};
		
		assertThrows(InvalidInputException.class, () -> {
			CronParserApplication.main(args);
		});
		
	}
	
	// Test Invalid Character 2
	@Test
	public void TestInvalidCharacter2() {
		String[] args = {"*/15 0 5! * 1-5 /usr/bin/find"};
		
		assertThrows(InvalidInputException.class, () -> {
			CronParserApplication.main(args);
		});
		
	}
	
	// Test Invalid Character 3
	@Test
	public void TestInvalidCharacter3() {
		String[] args = {"?/15 0 5 * 1-5 /usr/bin/find"};
		
		assertThrows(InvalidInputException.class, () -> {
			CronParserApplication.main(args);
		});
		
	}
	
	// Test Invalid Input
	@Test
	public void TestInvalidInput() {
		String[] args = {""};
		
		assertThrows(InvalidInputException.class, () -> {
			CronParserApplication.main(args);
		});
		
	}
	
	// Test Invalid Input 1
	@Test
	public void TestInvalidInput1() {
		String[] args = {"*/10 5 1,12 * 1-8"};
		
		assertThrows(InvalidInputException.class, () -> {
			CronParserApplication.main(args);
		});
		
	}
	
	// Test Invalid Input 2
	@Test
	public void TestInvalidInput2() {
		String[] args = {"*/10 5 1,12 * /usr/bin/find"};
		
		assertThrows(InvalidInputException.class, () -> {
			CronParserApplication.main(args);
		});
		
	}
	
	// Test Invalid Input 3
	@Test
	public void TestInvalidInput3() {
		String[] args = {"*/10 1,12 * /usr/bin/find"};
		
		assertThrows(InvalidInputException.class, () -> {
			CronParserApplication.main(args);
		});
		
	}
	
	// Test Invalid Input 4
	@Test
	public void TestInvalidInput4() {
		String[] args = {"* * * * /usr/bin/find"};
		
		assertThrows(InvalidInputException.class, () -> {
			CronParserApplication.main(args);
		});
		
	}
	
	//Test out of bound range
	@Test
	public void TestRangeOutOfBound() {
		String[] args = new String[1];
		args[0] = "*/10 5 1,12 * 1-8 /usr/bin/find";
		
		assertThrows(RangeOutOfBoundException.class, () -> {
			CronParserApplication.main(args);
		});
		
	}
	
	//Test out of bound range 1
	@Test
	public void TestRangeOutOfBound1() {
		String[] args = new String[1];
		args[0] = "*/10 5 1,35 * 1-4 /usr/bin/find";
		
		assertThrows(RangeOutOfBoundException.class, () -> {
			CronParserApplication.main(args);
		});
		
	}
	
	//Test out of bound range 2
	@Test
	public void TestRangeOutOfBound2() {
		String[] args = new String[1];
		args[0] = "*/10 30 1,12 * 1-8 /usr/bin/find";
		
		assertThrows(RangeOutOfBoundException.class, () -> {
			CronParserApplication.main(args);
		});
		
	}
	
	//Test out of bound range 3
	@Test
	public void TestRangeOutOfBound3() {
		String[] args = new String[1];
		args[0] = "0-70 20 1,12 * 1-5 /usr/bin/find";
		
		assertThrows(RangeOutOfBoundException.class, () -> {
			CronParserApplication.main(args);
		});
		
	}
	
	//Test out of bound range 4
	@Test
	public void TestRangeOutOfBound4() {
		String[] args = new String[1];
		args[0] = "*/10 20 1,12 13 1-5 /usr/bin/find";
		
		assertThrows(RangeOutOfBoundException.class, () -> {
			CronParserApplication.main(args);
		});
		
	}

}
