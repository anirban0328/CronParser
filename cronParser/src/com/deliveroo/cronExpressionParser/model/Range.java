package com.deliveroo.cronExpressionParser.model;

public class Range {
	private int start;
	private int end;

	Range(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	/**
	 * Checks if the value is within the range
	 * 
	 * @param value
	 * @return
	 */
	public boolean isValid(int value) {
		if (value >= start && value <= end)
			return true;
		else
			return false;
	}
}
