package com.WeatherShopper.web;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.WeatherShopper.base.pages.WeatherShopperPage;
import com.WeatherShopper.constants.Constants;
import com.WeatherShopper.listener.WeatherShopperEventListener;
import com.WeatherShopper.session.WeatherShopperTestSession;

public class WeatherShopperDriver extends WeatherShopperValidationDriver{

	public WeatherShopperDriver() {
		
		try {
			prop = new Properties();
			FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+ "/src/test/resources/project.properties");
			prop.load(fs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void openBrowser(String browserName) {
		log("Opening browser "+browserName);
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver/chromedriver");
		driver = new EventFiringWebDriver(new ChromeDriver());
		driver.register(new WeatherShopperEventListener());
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	public void navigate(String urlKey) {
		log("Navigating to Weather Shopper Website "+urlKey);
		String url = prop.getProperty(urlKey);
		log("URL: "+url);
		driver.get(url);
	}

	public void quit() {
		if(driver!=null)
			driver.quit();
	}
	
	public EventFiringWebDriver getCurrentDriver() {
		return driver;
	}
	
	public void waitForElementLoad(String objectKey) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		By locator = getObject(objectKey);

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));		
	}

	public void click(String objectKey) {
		log("Clicking on "+objectKey);
		driver.findElement(getObject(objectKey)).click();
	}
	
	public void type(String objectKey, String data) {
		log("Typing in "+objectKey+" Data "+data);
		driver.findElement(getObject(objectKey)).sendKeys(data);
	}
	
	public void clear(String objectKey) {
		driver.findElement(getObject(objectKey)).clear();
	}
	
	public String getText(String objectKey) {
		return driver.findElement(getObject(objectKey)).getText();
	}
	
	
}
