package com.edu.test.util;

import com.edu.test.model.Day;
import com.edu.test.repository.Period;

public class PrinterPeriod {

	public void printAverageTemperaturePeriod(Period period) {
		System.out.println("Средняя температура по дням:");
		for (int i = 0; i < period.getDays().length; i++) {
			System.out.printf("%s - %.1f\n", period.getDays()[i].getDate(),
					period.getDays()[i].getTemperatureAverage());
		}
	}

	public void printRiseInterval(Period period) {
		System.out.printf("С %s по %s\n", period.getDays()[0].getDate(),
				period.getDays()[period.getDays().length - 1].getDate());
	}

	public void printPeriodData(Period period, String message) {
		if (message != null) {
			System.out.println(message);
		}
		for (Day day : period.getDays()) {
			System.out.printf("%s: %d-%d-%d\n", day.getDate(), day.getTemperatureMorning(), day.getTemperatureMidday(),
					day.getTemperatureEvening());
		}
	}
}
