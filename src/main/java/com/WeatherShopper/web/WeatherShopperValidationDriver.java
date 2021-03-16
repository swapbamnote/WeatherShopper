package com.WeatherShopper.web;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.WeatherShopper.base.pages.WeatherShopperPage;
import com.WeatherShopper.session.WeatherShopperTestSession;

public abstract class WeatherShopperValidationDriver implements WebConnector {

	EventFiringWebDriver driver;
	boolean stopExecution;
	SoftAssert softAssert = new SoftAssert();

	public WeatherShopperPage validateTitle(String expectedTitle) {
		//Assert.assertEquals(driver.getTitle(), expectedTitle);
		if(!expectedTitle.equalsIgnoreCase(driver.getTitle())) {
			softAssert.fail("Titles do not match, Got title as "+driver.getTitle());
			if(isStopExecution()) {
				softAssert.assertAll();
			}
		}
		return getSession().getCurrentPage();
	}

	public WeatherShopperPage validateText(String locator, String expectedText) {
		// TODO Auto-generated method stub
		return getSession().getCurrentPage();
	}
	
	public WeatherShopperTestSession getSession() {
		return (WeatherShopperTestSession) Reporter.getCurrentTestResult().getTestContext().getAttribute("session");
	}

	public boolean isStopExecution() {
		return stopExecution;
	}

	public void setStopExecution(boolean stopExecution) {
		this.stopExecution = stopExecution;
	}
	
	public void assertAll() {
		softAssert.assertAll();
	}

}
