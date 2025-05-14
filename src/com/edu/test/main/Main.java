package com.edu.test.main;

import com.edu.test.controller.Controller;
import com.edu.test.model.Day;
import com.edu.test.repository.Period;
import com.edu.test.service.Service;
import com.edu.test.util.Printer;
import com.edu.test.util.TemperatureAnalyzer;

public class Main {

	public static void main(String[] args) {
		Day[] testDays = new Day[7];
		initHardCode(testDays);

		Period testPeriod = new Period(testDays);
		TemperatureAnalyzer analyzer = new TemperatureAnalyzer();
		Printer printer = new Printer();
		Service service = new Service(testPeriod, analyzer, printer);
		Controller controller = new Controller(service);

		printer.printMessage("Исходные данные после инициализации:\n(Дата: Tутро-Tдень-Tвечер (Tсредняя))");
		printer.printPeriodFullData(testPeriod);
		System.out.println();

		controller.showAverageTemperaturePeriod();
		System.out.println();

		controller.showAverageTemperatureRisePeriods();

	}

	// вспомогательный метод для инициализациии модели исходными данными по условию задачи
	public static void initHardCode(Day[] days) {
		String[] dates = { "2024-04-24", "2024-04-25", "2024-04-26", "2024-04-27", "2024-04-28", "2024-04-29",
				"2024-04-30" };
		int[] temperatureMorning = { 10, 12, 11, 13, 15, 17, 16 };
		int[] temperatureMidday = { 15, 16, 15, 18, 20, 22, 21 };
		int[] temperatureEvening = { 12, 13, 14, 15, 17, 19, 18 };
		for (int i = 0; i < days.length; i++) {
			days[i] = new Day(dates[i], temperatureMorning[i], temperatureMidday[i], temperatureEvening[i]);
		}
	}
}
