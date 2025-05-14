package com.edu.test.model;

import java.util.Objects;

public class Day {
	private String date;
	private int temperatureMorning;
	private int temperatureMidday;
	private int temperatureEvening;
	private double temperatureAverage;

	public Day(String date, int temperatureMorning, int temperatureMidday, int temperatureEvening) {
		this.date = date;
		this.temperatureMorning = temperatureMorning;
		this.temperatureMidday = temperatureMidday;
		this.temperatureEvening = temperatureEvening;
		initializeTemperatureAverage();
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getTemperatureMorning() {
		return temperatureMorning;
	}

	public void setTemperatureMorning(int temperatureMorning) {
		this.temperatureMorning = temperatureMorning;
	}

	public int getTemperatureMidday() {
		return temperatureMidday;
	}

	public void setTemperatureMidday(int temperatureMidday) {
		this.temperatureMidday = temperatureMidday;
	}

	public int getTemperatureEvening() {
		return temperatureEvening;
	}

	public void setTemperatureEvening(int temperatureEvening) {
		this.temperatureEvening = temperatureEvening;
	}

	private void initializeTemperatureAverage() {
		temperatureAverage = (int) ((temperatureMorning + temperatureMidday + temperatureEvening) / 3.0 * 10) / 10.0;
	}

	public double getTemperatureAverage() {
		return temperatureAverage;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, temperatureAverage, temperatureEvening, temperatureMidday, temperatureMorning);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Day other = (Day) obj;
		return Objects.equals(date, other.date)
				&& Double.doubleToLongBits(temperatureAverage) == Double.doubleToLongBits(other.temperatureAverage)
				&& temperatureEvening == other.temperatureEvening && temperatureMidday == other.temperatureMidday
				&& temperatureMorning == other.temperatureMorning;
	}

	@Override
	public String toString() {
		return "Day [" + (date != null ? "date=" + date + ", " : "") + "temperatureMorning=" + temperatureMorning
				+ ", temperatureMidday=" + temperatureMidday + ", temperatureEvening=" + temperatureEvening
				+ ", temperatureAverage=" + temperatureAverage + "]";
	}

}