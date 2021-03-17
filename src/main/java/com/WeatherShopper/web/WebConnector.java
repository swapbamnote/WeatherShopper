package com.WeatherShopper.web;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.asserts.SoftAssert;

import com.WeatherShopper.session.WeatherShopperTestSession;

public interface WebConnector extends WeatherShopperWebConnector{

	void openBrowser(String browserName);
	void navigate(String url);
	void quit();
	EventFiringWebDriver getCurrentDriver();
	void waitForElementLoad();
	WeatherShopperTestSession getSession(); 
	boolean isStopExecution();
	void setStopExecution(boolean stopExecution);
	void assertAll();
	SoftAssert getSoftAssert();
	void setSoftAssert(SoftAssert softAssert);
	void log(String message);
	void fail(String message);

}
