package com.WeatherShopper.web;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Reporter;

import com.WeatherShopper.base.pages.WeatherShopperPage;
import com.WeatherShopper.listener.WeatherShopperEventListener;
import com.WeatherShopper.session.WeatherShopperTestSession;

public class WeatherShopperDriver extends WeatherShopperValidationDriver{

	public WeatherShopperDriver() {
		
		try {
			prop = new Properties();
			FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\resources\\project.properties");
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
		// TODO Auto-generated method stub
		
	}
	
	public EventFiringWebDriver getCurrentDriver() {
		return driver;
	}
	
	public void waitForElementLoad() {
		
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
	
}
