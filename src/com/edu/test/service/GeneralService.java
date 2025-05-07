package com.edu.test.service;

import com.edu.test.logic.TemperatureAnalyzer;
import com.edu.test.repository.Period;
import com.edu.test.util.PrinterPeriod;

public class GeneralService {
	Period period;
	TemperatureAnalyzer analyzer;
	PrinterPeriod printer;

	public GeneralService(Period period, TemperatureAnalyzer analyzer, PrinterPeriod printer) {
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

	public void setPrinter(PrinterPeriod printer) {
		this.printer = printer;
	}

	public void showAverageTemperaturePeriod() {
		printer.printAverageTemperaturePeriod(period);
	}

	public void showAverageTemperatureRisePeriods() {
		Period[] averageTemperatureRisePeriods = analyzer.getAverageTemperatureRisePeriods(period);
		if (averageTemperatureRisePeriods[0].getDays().length == 1) {
			System.out.println("Нет периодов роста средней температуры");
		} else {
			System.out.println("Самый длинный период повышения: " + (averageTemperatureRisePeriods[0].getDays().length - 1) + " д.");
			System.out.println("Найдено таких периодов: " + averageTemperatureRisePeriods.length);
			for (Period period : averageTemperatureRisePeriods) {
				printer.printRiseInterval(period);
			}
		}
	}
}
