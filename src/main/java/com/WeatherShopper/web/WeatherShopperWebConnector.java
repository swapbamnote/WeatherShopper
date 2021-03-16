package com.WeatherShopper.web;

import com.WeatherShopper.base.pages.WeatherShopperPage;

public interface WeatherShopperWebConnector {

	WeatherShopperPage validateTitle(String expectedTitle);
	WeatherShopperPage validateText(String locator, String expectedText);
	
	/*void openBrowser(String browserName);
	void navigate(String url);
	void quit();*/
	
}
