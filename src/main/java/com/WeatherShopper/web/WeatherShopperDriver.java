package com.WeatherShopper.web;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Reporter;

import com.WeatherShopper.base.pages.WeatherShopperPage;
import com.WeatherShopper.listener.WeatherShopperEventListener;
import com.WeatherShopper.session.WeatherShopperTestSession;

public class WeatherShopperDriver extends WeatherShopperValidationDriver{

	public void openBrowser(String browserName) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver/chromedriver");
		driver = new EventFiringWebDriver(new ChromeDriver());
		driver.register(new WeatherShopperEventListener());
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	public void navigate(String url) {
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

	
	
	
}
