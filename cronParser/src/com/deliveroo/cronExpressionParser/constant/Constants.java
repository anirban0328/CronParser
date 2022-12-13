package com.deliveroo.cronExpressionParser.constant;

public class Constants {

	public static final String SPACE = "\\s+";
	public static final String NUMERIC = "\\d+";
	public static final String ASTERISK = "*";
	public static final String COMMA = ",";
	public static final String DASH = "-";
	public static final String SLASH = "*/";

	public static final String DELIMITER = "%-14s%s%s";
	public static final String EOL = "\n";

	public static final String OUTOFRANGE = "The input is out of range";
	public static final String INVALIDINPUT = "Invalid Input. Please try in the format: "
			+ "\"*/15 0 1,15 * 1-5 /usr/bin/find\"";

	public static final String MINUTE = "minute";
	public static final String HOUR = "hour";
	public static final String DAYOFMONTH = "day of month";
	public static final String MONTH = "month";
	public static final String DAYOFWEEK = "day of week";
	public static final String COMMAND = "command";
}
