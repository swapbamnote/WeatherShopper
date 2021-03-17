package com.WeatherShopper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.WeatherShopper.base.pages.WeatherShopperPage;
import com.WeatherShopper.constants.Constants;
import com.WeatherShopper.listener.WeatherShopperEventListener;
import com.WeatherShopper.reports.ExtentManager;
import com.WeatherShopper.session.WeatherShopperTestSession;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ProductTypeTest {
	
	WeatherShopperTestSession session;
	
	@BeforeMethod
	public void initialize() {
		
		//webconnector is initialize
		session = new WeatherShopperTestSession();//new driver, new browser, onesessionpertest
	}
	
	@AfterMethod
	public void quit() {
		session.generateReport();
	}
	
	@Test
	public void chooseProductType() {
		session
		.init("Choose Product Test") //store session in testContext and return object of launchpage
		.openBrowser("chrome")
		.goToHomePage()
		.validator(false).validateTitle(Constants.HOME_PAGE_TITLE)
		.goToMoisturizerPage();
		
		session.end();
				
	}

}
