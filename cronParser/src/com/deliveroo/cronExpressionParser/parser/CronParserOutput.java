package com.deliveroo.cronExpressionParser.parser;

import java.util.List;

public class CronParserOutput {
	private List<Integer> minutes;
	private List<Integer> hours;
	private List<Integer> dayOfMonths;
	private List<Integer> months;
	private List<Integer> dayOfWeeks;
	private String command;

	public List<Integer> getMinutes() {
		return minutes;
	}

	public void setMinutes(List<Integer> minutes) {
		this.minutes = minutes;
	}

	public List<Integer> getHours() {
		return hours;
	}

	public void setHours(List<Integer> hours) {
		this.hours = hours;
	}

	public List<Integer> getDayOfMonths() {
		return dayOfMonths;
	}

	public void setDayOfMonths(List<Integer> dayOfMonths) {
		this.dayOfMonths = dayOfMonths;
	}

	public List<Integer> getMonths() {
		return months;
	}

	public void setMonths(List<Integer> months) {
		this.months = months;
	}

	public List<Integer> getDayOfWeeks() {
		return dayOfWeeks;
	}

	public void setDayOfWeeks(List<Integer> dayOfWeeks) {
		this.dayOfWeeks = dayOfWeeks;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

}
