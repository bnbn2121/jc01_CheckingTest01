package com.edu.test.util;

import com.edu.test.model.Day;
import com.edu.test.repository.Period;

//решил сделать через дополнительный массив флагов. Просто так сразу придумал и захотел попробовать.
public class TemperatureAnalyzer {

	// создаю логику расстановки флагов под нашу задачу на рост температуры
	private int[] getAverageTemperatureRiseFlags(Period period) {
		double[] averageTemperaturePeriod = period.getAverageTemperaturePeriod();
		int[] temperatureRiseFlags = new int[averageTemperaturePeriod.length]; // значение флага будет показывать кол-во
																				// дней с ростом температуры в данной точке
		int currentFlag = 0;
		for (int i = 1; i < averageTemperaturePeriod.length; i++) {
			if (averageTemperaturePeriod[i] > averageTemperaturePeriod[i - 1]) {
				temperatureRiseFlags[i] = ++currentFlag;
			} else {
				currentFlag = 0;
			}
		}
		return temperatureRiseFlags;
	}

	// вспомогательный метод для поиска максимального значения флага
	private int getMaxFlagValue(int[] flags) {
		int maxFlagValue = flags[0];
		for (int flag : flags) {
			if (flag > maxFlagValue) {
				maxFlagValue = flag;
			}
		}
		return maxFlagValue;
	}

	// вспомогательный метод для поиска количества флагов по значению
	private int getFlagCount(int[] flags, int flagValue) {
		int flagCount = 0;
		for (int flag : flags) {
			if (flag == flagValue) {
				flagCount++;
			}
		}
		return flagCount;
	}

	// вспомогательный метод для получения периодов по заданным словиям из
	// некоторого исходного периода
	private Period[] getResultPeriods(Period period, int[] flags, int flagValue) {
		int countFlagValue = getFlagCount(flags, flagValue);
		Period[] resultPeriods = new Period[countFlagValue];

		for (int i = 0, j = 0; i < flags.length; i++) {
			if (flags[i] == flagValue) {
				Day[] nextDays = new Day[flagValue + 1]; // +1 для учета в результирующем массиве нулевого элемента
				for (int k = i, m = flagValue; m >= 0; k--, m--) { // при нахождении нужного флага - заполняем массив
																	// данными в обратном порядке до нулевого флага
					nextDays[m] = period.getDays()[k];
				}
				resultPeriods[j++] = new Period(nextDays);
			}
		}
		return resultPeriods;
	}

	// получаем искомые периоды, комбинируя необходимые методы
	public Period[] getAverageTemperatureRisePeriods(Period period) {
		int[] averageTemperatureRiseFlags = getAverageTemperatureRiseFlags(period);
		int maxDurationRise = getMaxFlagValue(averageTemperatureRiseFlags);
		Period[] resultPeriods = getResultPeriods(period, averageTemperatureRiseFlags, maxDurationRise);
		return resultPeriods;
	}

}
