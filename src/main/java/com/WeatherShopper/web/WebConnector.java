package com.WeatherShopper.web;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.asserts.SoftAssert;

import com.WeatherShopper.session.WeatherShopperTestSession;

public interface WebConnector extends WeatherShopperWebConnector{

	void openBrowser(String browserName);
	void navigate(String urlKey);
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
	By getObject(String objectKey);
	void click(String object);
	void type(String objectKey, String data);
	void clear(String objectKey);
	String getText(String objectKey);
	List<Integer> getTemperature(String tempContent);
	WebElement addToCart(List<WebElement> pageOptions, String lotionContent);
}
