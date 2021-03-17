package com.WeatherShopper.web;

import org.openqa.selenium.By;

import com.WeatherShopper.base.pages.WeatherShopperPage;

public interface WeatherShopperWebConnector {

	WeatherShopperPage validateTitle(String expectedTitle);
	WeatherShopperPage validateText(By locator, String expectedText);
	WeatherShopperPage validateElementPresence(By locator);
	
	boolean isElementPresent(By locator);
	/*void openBrowser(String browserName);
	void navigate(String url);
	void quit();*/
	
}
