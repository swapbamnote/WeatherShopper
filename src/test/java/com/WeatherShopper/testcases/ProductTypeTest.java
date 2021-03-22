package com.WeatherShopper.testcases;

import org.testng.annotations.Test;
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
import com.WeatherShopper.dataprovider.TestDataProvider;
import com.WeatherShopper.listener.WeatherShopperEventListener;
import com.WeatherShopper.pages.application.LaunchPage;
import com.WeatherShopper.reports.ExtentManager;
import com.WeatherShopper.session.WeatherShopperTestSession;
import com.WeatherShopper.tests.base.TestBase;
import com.WeatherShopper.util.DataUtil;
import com.WeatherShopper.util.Xls_Reader;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ProductTypeTest extends TestBase{
	
	@Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData")
	public void productTypeTest(Hashtable<String, String> data) {
		session.log(data.toString());
		
		if(!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equalsIgnoreCase("N")) {
			//skip in extent report
			session.skipTest("Skipping the test as Runmode is No");
			//skip in testng
			throw new SkipException("Skipping the test as Runmode is No");
		}

		WeatherShopperPage page =
		new LaunchPage()
		.openBrowser(data.get("Browser"))
		.goToHomePage()
		.validator(false).validateTitle(Constants.HOME_PAGE_TITLE_KEY);
		session.end();

	}

}
