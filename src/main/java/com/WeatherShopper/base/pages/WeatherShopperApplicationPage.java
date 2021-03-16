package com.WeatherShopper.base.pages;

import com.WeatherShopper.web.WebConnector;

public interface WeatherShopperApplicationPage {

	//application functions
	WeatherShopperPage goToHomePage();
	WeatherShopperPage goToMoisturizerPage();
	void goToSunscreenPage();
	void goToCheckoutPage();
	WebConnector validator();
}
