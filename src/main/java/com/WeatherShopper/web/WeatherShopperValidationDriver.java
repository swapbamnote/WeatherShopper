package com.WeatherShopper.web;

import java.time.Duration;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;
import com.WeatherShopper.base.pages.WeatherShopperPage;
import com.WeatherShopper.constants.Constants;
import com.WeatherShopper.session.WeatherShopperTestSession;

public abstract class WeatherShopperValidationDriver implements WebConnector {

	EventFiringWebDriver driver;
	Properties prop;
	boolean stopExecution;
	SoftAssert softAssert = new SoftAssert();

	public WeatherShopperPage validateTitle(String expectedTitleKey) {
		log("Expected Title "+prop.getProperty(expectedTitleKey));
		log("Actual Title "+driver.getTitle());
		//Assert.assertEquals(driver.getTitle(), expectedTitle);
		if(!prop.getProperty(expectedTitleKey).equalsIgnoreCase(driver.getTitle())) {
			fail("Titles do not match, got title as "+driver.getTitle());
		}
		return getSession().getCurrentPage();
	}

	public WeatherShopperPage validateText(String objectKey, String expectedText) {
		By locator = getObject(objectKey);
		String actualText = driver.findElement(locator).getText();
		if(!actualText.equals(expectedText)) {
			fail("Text do not match, expected: "+expectedText+ "actual text: "+actualText);
		}
		return getSession().getCurrentPage();
	}
	
	public WeatherShopperPage validateCart(Hashtable<String, String> addedProductsOnLotionPage) {
		Hashtable<String, String> cartProducts = new Hashtable<String, String>();
		List<WebElement> cartRows = driver.findElements(getObject(Constants.CART_ROWS_KEY));
		for(int rNum=0; rNum< cartRows.size(); rNum++) {
			WebElement row= cartRows.get(rNum);
			List<WebElement> cells = row.findElements(getObject(Constants.CART_COLUMNS_KEY));
			cartProducts.put(cells.get(0).getText(), cells.get(1).getText());
		}
		log("Displayed products in a cart: "+cartProducts);
		log("Added products on a lotion page: "+addedProductsOnLotionPage);
		if(!cartProducts.equals(addedProductsOnLotionPage)) {
			fail("Cart do not match, Expected Cart: "+addedProductsOnLotionPage+ "Displayed Cart: "+cartProducts);
		}
		return getSession().getCurrentPage();
	}
	
	public WeatherShopperPage validateElementPresence(String objectKey) {
		
		if(!isElementPresent(objectKey)) {
			fail("locator not found "+objectKey);
		}
		return getSession().getCurrentPage();
	}
	
	public boolean isElementPresent(String objectKey) {
		By locator = getObject(objectKey);
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
	
	public By getObject(String objectKey) {
		By locatorStrategy = null;
		
		if(objectKey.endsWith("_id")) 
			locatorStrategy = By.id(prop.getProperty(objectKey));
		else if(objectKey.endsWith("_name")) 
			locatorStrategy = By.name(prop.getProperty(objectKey));
		else if(objectKey.endsWith("_xpath")) 
			locatorStrategy = By.xpath(prop.getProperty(objectKey));
		else if(objectKey.endsWith("_css")) 
			locatorStrategy = By.cssSelector(prop.getProperty(objectKey));
		else if(objectKey.endsWith("_tagName")) 
			locatorStrategy = By.tagName(prop.getProperty(objectKey));
		
		return locatorStrategy;
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
