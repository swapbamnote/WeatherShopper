package com.WeatherShopper;

import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.WeatherShopper.base.pages.WeatherShopperPage;
import com.WeatherShopper.constants.Constants;
import com.WeatherShopper.listener.WeatherShopperEventListener;
import com.WeatherShopper.pages.application.LaunchPage;
import com.WeatherShopper.reports.ExtentManager;
import com.WeatherShopper.session.WeatherShopperTestSession;
import com.WeatherShopper.util.DataUtil;
import com.WeatherShopper.util.Xls_Reader;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ProductTypeTest {
	
	WeatherShopperTestSession session;
	String testName = "MoisturizerTest";
	Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir")+"//Data.xlsx");
	
	@BeforeMethod
	public void initialize() {
		
		//webconnector is initialize
		session = new WeatherShopperTestSession();//new driver, new browser, onesessionpertest
		session.init("Choose Product Test"); //store session in testContext and return object of launchpage
	}
	
	@AfterMethod
	public void quit() {
		session.generateReport();
	}
	
	@Test(dataProvider = "getData")
	public void chooseProductType(Hashtable<String, String> data) {
		session.log(data.toString());
		
		if(!DataUtil.isRunnable(testName, xls) || data.get("Runmode").equalsIgnoreCase("N")) {
			//skip in extent report
			session.skipTest("Skipping the test as Runmode is No");
			//skip in testng
			throw new SkipException("Skipping the test as Runmode is No");
		}
		
		WeatherShopperPage Page = 
			new LaunchPage()
			.openBrowser("chrome")
			.goToHomePage()
			.validator(false).validateTitle(Constants.HOME_PAGE_TITLE)
			.goToMoisturizerPage();
		
		/*if(page instanceof MositurizerPage) {
			page.
		} else if(page instanceof SunscreenPage) {
			
		} else {
			
		}*/
		session.end();
				
	}
	
	@DataProvider
	public Object[][] getData() {
		return DataUtil.getData(testName, xls);
	} 

}
