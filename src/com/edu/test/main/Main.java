package com.edu.test.main;

import com.edu.test.logic.TemperatureAnalyzer;
import com.edu.test.model.Day;
import com.edu.test.repository.Period;
import com.edu.test.service.GeneralService;
import com.edu.test.util.PrinterPeriod;

public class Main {

	public static void main(String[] args) {
		Day[] testDays = new Day[7];
		initHardCode(testDays);

		Period testPeriod = new Period(testDays);
		TemperatureAnalyzer analyzer = new TemperatureAnalyzer();
		PrinterPeriod printer = new PrinterPeriod();
		GeneralService service = new GeneralService(testPeriod, analyzer, printer);

		printer.printPeriodData(testPeriod,
				"Исходные данные после инициализации:\n(в формате \"Дата: Tутро-Tдень-Tвечер\")");
		System.out.println();

		service.showAverageTemperaturePeriod();
		System.out.println();

		service.showAverageTemperatureRisePeriods();

	}

	// вспомогательный метод для инициализации
	public static void initHardCode(Day[] days) {
		String[] dates = { "2024-04-24", "2024-04-25", "2024-04-26", "2024-04-27", "2024-04-28", "2024-04-29",
				"2024-04-30" };
		int[] temperatureMorning = { 10, 12, 11, 13, 5, 17, 16 };
		int[] temperatureMidday = { 15, 16, 15, 18, 20, 22, 21 };
		int[] temperatureEvening = { 12, 13, 14, 15, 17, 19, 18 };
		for (int i = 0; i < days.length; i++) {
			days[i] = new Day(dates[i], temperatureMorning[i], temperatureMidday[i], temperatureEvening[i]);
		}
	}
}
