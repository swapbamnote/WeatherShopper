package com.WeatherShopper.web;

import org.openqa.selenium.support.events.EventFiringWebDriver;

public interface WebConnector {

	void openBrowser(String browserName);
	void navigate(String url);
	void quit();
	EventFiringWebDriver getCurrentDriver();
	void waitForElementLoad();
}
