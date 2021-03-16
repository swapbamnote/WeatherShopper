package com.WeatherShopper.base.pages;

public interface WeatherShopperPage extends WeatherShopperApplicationPage{
	
	//normal browser functions
	void openBrowser(String browserName);
	void quit();
	void getTotalWindows();
	
	//application functions
	void goToHomePage();
	void goToMoisturizerPage();
	void goToSunscreenPage();
	void goToCheckoutPage();
	
	void validator();
	
}
