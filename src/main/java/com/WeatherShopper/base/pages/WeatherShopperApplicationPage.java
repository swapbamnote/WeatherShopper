package com.WeatherShopper.base.pages;

import com.WeatherShopper.web.WebConnector;

public interface WeatherShopperApplicationPage {

	//application functions
	WeatherShopperPage goToHomePage();
	WeatherShopperPage selectLotionPage();
	WeatherShopperPage goToMoisturizerPage();
	WeatherShopperPage goToSunscreenPage();
	void goToCheckoutPage();
	WebConnector validator(boolean stopExecution);
}
