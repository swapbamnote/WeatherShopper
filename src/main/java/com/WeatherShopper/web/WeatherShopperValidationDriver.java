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
		log("Expected Title "+expectedTitle);
		log("Actual Title "+driver.getTitle());
		//Assert.assertEquals(driver.getTitle(), expectedTitle);
		if(!expectedTitle.equalsIgnoreCase(driver.getTitle())) {
			fail("Titles do not match, got title as "+driver.getTitle());
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

	public SoftAssert getSoftAssert() {
		return softAssert;
	}

	public void setSoftAssert(SoftAssert softAssert) {
		this.softAssert = softAssert;
	}

	public void log(String message) {
		getSession().log(message);
	}
	
	public void fail(String message) {
		// fail in extent report
		getSession().failTest(message);
		// fail in testng
		softAssert.fail("Titles do not match, Got title as "+driver.getTitle());
		// decide if execution has to be stopped
		if(isStopExecution()) {
			assertAll();
		}
	}
}
