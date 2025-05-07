package com.edu.test.repository;

import java.util.Arrays;

import com.edu.test.model.Day;

public class Period {
	Day[] days;

	public Period(Day[] days) {
		this.days = days;
	}

	public Day[] getDays() {
		return days;
	}

	public void setDays(Day[] days) {
		this.days = days;
	}

	public double[] getAverageTemperaturePeriod() {
		double[] averageTemperaturePeriod = new double[days.length];
		for (int i = 0; i < days.length; i++) {
			averageTemperaturePeriod[i] = days[i].getTemperatureAverage();
		}
		return averageTemperaturePeriod;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(days);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Period other = (Period) obj;
		return Arrays.equals(days, other.days);
	}

	@Override
	public String toString() {
		return "Period [" + (days != null ? "days=" + Arrays.toString(days) : "") + "]";
	}

}
