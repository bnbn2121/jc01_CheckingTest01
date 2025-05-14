package com.edu.test.service;

import com.edu.test.repository.Period;
import com.edu.test.util.Printer;
import com.edu.test.util.TemperatureAnalyzer;

public class Service {
	Period period;
	TemperatureAnalyzer analyzer;
	Printer printer;

	public Service(Period period, TemperatureAnalyzer analyzer, Printer printer) {
		this.period = period;
		this.analyzer = analyzer;
		this.printer = printer;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

	public void setAnalyzer(TemperatureAnalyzer analyzer) {
		this.analyzer = analyzer;
	}

	public void setPrinter(Printer printer) {
		this.printer = printer;
	}

	public void showAverageTemperaturePeriod() {
		printer.printMessage("Средняя температура по дням:");
		for (int i = 0; i < period.getDays().length; i++) {
			printer.printDayAverageTemperature(period.getDays()[i]);
		}
	}

	public void showAverageTemperatureRisePeriods() {
		Period[] averageTemperatureRisePeriods = analyzer.getAverageTemperatureRisePeriods(period);
		if (averageTemperatureRisePeriods[0].getDays().length == 1) {
			printer.printMessage("Нет периодов роста средней температуры");
		} else {
			printer.printMessage("Самый длинный период повышения: "
					+ (averageTemperatureRisePeriods[0].getDays().length - 1) + " д.");
			printer.printMessage("Найдено таких периодов: " + averageTemperatureRisePeriods.length);
			for (Period period : averageTemperatureRisePeriods) {
				printer.printPeriodFirstAndLastDay(period);
			}
		}
	}
}
