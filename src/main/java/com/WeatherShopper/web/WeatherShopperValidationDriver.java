package com.WeatherShopper.web;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.WeatherShopper.base.pages.WeatherShopperPage;
import com.WeatherShopper.session.WeatherShopperTestSession;

public abstract class WeatherShopperValidationDriver implements WebConnector {

	EventFiringWebDriver driver ;

	public WeatherShopperPage validateTitle(String expectedTitle) {
		Assert.assertEquals(driver.getTitle(), expectedTitle);
		return getSession().getCurrentPage();
	}

	public WeatherShopperPage validateText(String locator, String expectedText) {
		// TODO Auto-generated method stub
		return getSession().getCurrentPage();
	}
	
	public WeatherShopperTestSession getSession() {
		return (WeatherShopperTestSession) Reporter.getCurrentTestResult().getTestContext().getAttribute("session");
	}

}
