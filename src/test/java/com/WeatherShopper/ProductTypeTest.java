package com.WeatherShopper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

import com.WeatherShopper.base.pages.WeatherShopperPage;
import com.WeatherShopper.listener.WeatherShopperEventListener;
import com.WeatherShopper.session.WeatherShopperTestSession;

public class ProductTypeTest {
	
	@Test
	public void chooseProductType() {
		
		//webconnector is initialize
		WeatherShopperTestSession session = new WeatherShopperTestSession();//new driver, new browser, onesessionpertest
		session
		.init() //store session in testContext and return object of launchpage
		.openBrowser("chrome")
		.goToHomePage()
		.goToMoisturizerPage();
		
		
		
	}

}
