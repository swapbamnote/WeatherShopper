package com.WeatherShopper.testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.WeatherShopper.base.pages.WeatherShopperPage;
import com.WeatherShopper.constants.Constants;
import com.WeatherShopper.dataprovider.TestDataProvider;
import com.WeatherShopper.pages.application.LaunchPage;
import com.WeatherShopper.tests.base.TestBase;
import com.WeatherShopper.util.DataUtil;

public class MoisturizerTest extends TestBase{

	@Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData")
	public void moisturizerTest(Hashtable<String, String> data) {
		session.log(data.toString());
		
		if(!DataUtil.isRunnable(testName, xls) || data.get("Runmode").equalsIgnoreCase("N")) {
			//skip in extent report
			session.skipTest("Skipping the test as Runmode is No");
			//skip in testng
			throw new SkipException("Skipping the test as Runmode is No");
		}
		
		WeatherShopperPage Page = 
			new LaunchPage()
			.openBrowser(data.get("Browser"))
			.goToHomePage()
			.validator(false).validateTitle(Constants.HOME_PAGE_TITLE_KEY)
			.goToMoisturizerPage();
		
		/*if(page instanceof MositurizerPage) {
			page.
		} else if(page instanceof SunscreenPage) {
			
		} else {
			
		}*/
		session.end();
				
	}
}
