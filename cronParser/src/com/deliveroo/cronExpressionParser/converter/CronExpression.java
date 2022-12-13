package com.deliveroo.cronExpressionParser.converter;

import com.deliveroo.cronExpressionParser.exception.InvalidInputException;
import com.deliveroo.cronExpressionParser.exception.RangeOutOfBoundException;
import com.deliveroo.cronExpressionParser.model.Command;
import com.deliveroo.cronExpressionParser.model.DayOfMonth;
import com.deliveroo.cronExpressionParser.model.DayOfWeek;
import com.deliveroo.cronExpressionParser.model.Hour;
import com.deliveroo.cronExpressionParser.model.Minute;
import com.deliveroo.cronExpressionParser.model.Month;

public class CronExpression {
	private Minute minute;
	private Hour hour;
	private DayOfMonth dayOfMonth;
	private Month month;
	private DayOfWeek dayOfWeek;
	private Command command;

	public Minute getMinute() {
		return minute;
	}

	public void setMinute(Minute minute) {
		this.minute = minute;
	}

	public Hour getHour() {
		return hour;
	}

	public void setHour(Hour hour) {
		this.hour = hour;
	}

	public DayOfMonth getDayOfMonth() {
		return dayOfMonth;
	}

	public void setDayOfMonth(DayOfMonth dayOfMonth) {
		this.dayOfMonth = dayOfMonth;
	}

	public Month getMonth() {
		return month;
	}

	public void setMonth(Month month) {
		this.month = month;
	}

	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public Command getCommand() {
		return command;
	}

	public void setCommand(Command command) {
		this.command = command;
	}

	/**
	 * Validate the input for invalid or out of range exception
	 * 
	 * @throws InvalidInputException
	 * @throws RangeOutOfBoundException
	 */
	public void validate() throws InvalidInputException, RangeOutOfBoundException {
		minute.validate();
		hour.validate();
		dayOfMonth.validate();
		month.validate();
		dayOfWeek.validate();
	}

}
