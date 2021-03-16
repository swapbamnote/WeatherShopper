package com.WeatherShopper.web;

import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.WeatherShopper.session.WeatherShopperTestSession;

public interface WebConnector extends WeatherShopperWebConnector{

	void openBrowser(String browserName);
	void navigate(String url);
	void quit();
	EventFiringWebDriver getCurrentDriver();
	void waitForElementLoad();
	
	WeatherShopperTestSession getSession(); 

}
