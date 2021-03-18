package com.WeatherShopper.web;

import org.openqa.selenium.By;

import com.WeatherShopper.base.pages.WeatherShopperPage;

public interface WeatherShopperWebConnector {

	WeatherShopperPage validateTitle(String expectedTitleKey);
	WeatherShopperPage validateText(String objectKey, String expectedText);
	WeatherShopperPage validateElementPresence(String objectKey);
	
	boolean isElementPresent(String objectKey);
	/*void openBrowser(String browserName);
	void navigate(String url);
	void quit();*/
	
}
