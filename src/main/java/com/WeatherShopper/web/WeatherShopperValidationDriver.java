package com.WeatherShopper.web;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.WeatherShopper.base.pages.WeatherShopperPage;
import com.WeatherShopper.constants.Constants;
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

	public WeatherShopperPage validateText(By locator, String expectedText) {
		String actualText = driver.findElement(locator).getText();
		if(!actualText.equals(expectedText)) {
			fail("Text do not match, got text as "+actualText);
		}
		return getSession().getCurrentPage();
	}
	
	public WeatherShopperPage validateElementPresence(By locator) {
		
		if(!isElementPresent(locator)) {
			fail("locator not found "+locator);
		}
		return getSession().getCurrentPage();
	}
	
	public boolean isElementPresent(By locator) {
		getSession().setExecuteListener(false);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
			wait.until(ExpectedConditions.elementToBeClickable(locator));
		} catch(TimeoutException e) {
			return false;
		}
		return true;
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
		softAssert.fail(message);
		// decide if execution has to be stopped
		if(isStopExecution()) {
			assertAll();
		}
	}
}
