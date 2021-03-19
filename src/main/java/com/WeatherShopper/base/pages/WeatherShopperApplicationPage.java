package com.WeatherShopper.base.pages;

import com.WeatherShopper.web.WebConnector;

public interface WeatherShopperApplicationPage {

	//application functions
	WeatherShopperPage goToHomePage();
	WeatherShopperPage selectLotionPage();
	WeatherShopperPage selectMoisturizer(String productContent);
	WeatherShopperPage selectSunscreen(String productContent);
	WeatherShopperPage goToCheckoutPage();
	WebConnector validator(boolean stopExecution);
}
