package com.edu.test.controller;

import com.edu.test.service.Service;

public class Controller {
	private Service service;

	public Controller(Service service) {
		this.service = service;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public void showAverageTemperaturePeriod() {
		service.showAverageTemperaturePeriod();
	}

	public void showAverageTemperatureRisePeriods() {
		service.showAverageTemperatureRisePeriods();
	}
}
