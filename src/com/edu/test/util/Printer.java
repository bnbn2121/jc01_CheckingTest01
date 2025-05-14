package com.edu.test.util;

import com.edu.test.model.Day;
import com.edu.test.repository.Period;

public class Printer {

	public void printDayAverageTemperature(Day day) {
		System.out.printf("%s - %.1f\n", day.getDate(), day.getTemperatureAverage());
	}

	public void printPeriodFirstAndLastDay(Period period) {
		System.out.printf("С %s по %s\n", period.getDays()[0].getDate(),
				period.getDays()[period.getDays().length - 1].getDate());
	}

	public void printPeriodFullData(Period period) {
		for (Day day : period.getDays()) {
			printDayFullData(day);
		}
	}
	
	public void printDayFullData(Day day) {
		System.out.printf("%s: %d-%d-%d (%.1f)\n", day.getDate(), day.getTemperatureMorning(), day.getTemperatureMidday(),
				day.getTemperatureEvening(), day.getTemperatureAverage());
	}

	public void printMessage(String message) {
		System.out.println(message);
	}
}
