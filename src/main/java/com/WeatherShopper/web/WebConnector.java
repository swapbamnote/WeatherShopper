package com.WeatherShopper.web;

public interface WebConnector {

	void openBrowser(String browserName);
	void navigate(String url);
	void quit();
}
