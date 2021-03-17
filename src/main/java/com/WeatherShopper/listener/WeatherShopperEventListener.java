package com.WeatherShopper.listener;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.testng.Reporter;

import com.WeatherShopper.session.WeatherShopperTestSession;
import com.WeatherShopper.web.WebConnector;

public class WeatherShopperEventListener extends AbstractWebDriverEventListener {

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		
		boolean error = true;
		if(error) {
			getDriver().fail("Element not found "+ by);
			getDriver().assertAll(); //end the test
		}
	}
	
	public WebConnector getDriver() {
		return getSession().getCon();
	}
	
	public WeatherShopperTestSession getSession() {
		return (WeatherShopperTestSession) Reporter.getCurrentTestResult().getTestContext().getAttribute("session");
	}
	
	public void log(String message) {
		getSession().log(message);
	}
}
