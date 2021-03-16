package com.WeatherShopper.base.pages;

public interface WeatherShopperPage extends WeatherShopperApplication{
	
	//normal browser functions
	void openBrowser();
	void quit();
	void getTotalWindows();
	
	//application functions
	void goToHomePage();
	void goToMoisturizerPage();
	void goToSunscreenPage();
	void goToCheckoutPage();
	
	void validator();
	
}
