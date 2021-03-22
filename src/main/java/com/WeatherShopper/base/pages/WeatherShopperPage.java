package com.WeatherShopper.base.pages;

import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.WeatherShopper.session.WeatherShopperTestSession;
import com.WeatherShopper.web.WebConnector;

public interface WeatherShopperPage extends WeatherShopperApplicationPage{

	//normal browser functions
	WeatherShopperPage openBrowser(String browserName);
	WeatherShopperTestSession getSession();
	void waitForPageToLoad();
	void wait(int time);
	WebConnector getDriver();
	void log(String message);
	void fail(String message);
	EventFiringWebDriver getCurrentDriver();
	WebConnector validator(boolean stopExecution);

	/*//application functions
	WeatherShopperPage goToHomePage();
	WeatherShopperPage selectLotionPage();
	WeatherShopperPage selectMoisturizer(String productContent);
	WeatherShopperPage selectSunscreen(String productContent);
	WeatherShopperPage goToCheckoutPage();
	WeatherShopperPage addPaymentDetails(String email, String ccNum, String expiryDate, String cvv, String zipCode);
	WeatherShopperPage getPaymentConfirmation();*/



}
