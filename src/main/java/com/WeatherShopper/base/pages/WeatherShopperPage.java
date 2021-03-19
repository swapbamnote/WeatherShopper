package com.WeatherShopper.base.pages;

import com.WeatherShopper.session.WeatherShopperTestSession;
import com.WeatherShopper.web.WebConnector;

public interface WeatherShopperPage extends WeatherShopperApplicationPage{
	
	//normal browser functions
	WeatherShopperPage openBrowser(String browserName);
	void quit();
	void getTotalWindows();
	WeatherShopperTestSession getSession(); 
	void waitForPageToLoad();
	void wait(int time);
	
	//application functions
	WeatherShopperPage goToHomePage();
	WeatherShopperPage selectLotionPage();
	WeatherShopperPage selectMoisturizer(String productContent);
	WeatherShopperPage selectSunscreen(String productContent);
	WeatherShopperPage goToCheckoutPage();
	WeatherShopperPage addPaymentDetails(String email, String ccNum, String expiryDate, String cvv, String zipCode);
	WeatherShopperPage getPaymentConfirmation();
	
	WebConnector validator(boolean stopExecution);
	
	//WebConnector getDriver();
	void log(String message);
	
}
