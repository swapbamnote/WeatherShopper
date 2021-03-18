package com.WeatherShopper.tests.base;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.WeatherShopper.session.WeatherShopperTestSession;
import com.WeatherShopper.util.Xls_Reader;

public class TestBase {
	public WeatherShopperTestSession session;
	public String testName = null;
	public Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir")+"//Data.xlsx");
	

	@BeforeMethod
	public void initialize(ITestResult result) {
		testName = result.getMethod().getMethodName().toUpperCase();
		//webconnector is initialize
		session = new WeatherShopperTestSession();//new driver, new browser, onesessionpertest
		session.init(testName); //store session in testContext and return object of launchpage
	}
	
	@AfterMethod
	public void quit() {
		session.generateReport();
	}
}
