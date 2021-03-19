package com.WeatherShopper.testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.WeatherShopper.base.pages.WeatherShopperPage;
import com.WeatherShopper.constants.Constants;
import com.WeatherShopper.dataprovider.TestDataProvider;
import com.WeatherShopper.pages.application.LaunchPage;
import com.WeatherShopper.pages.application.MoisturizerPage;
import com.WeatherShopper.pages.application.SunscreenPage;
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
		
		WeatherShopperPage page = 
			new LaunchPage()
			.openBrowser(data.get("Browser"))
			.goToHomePage()
			.validator(false).validateTitle(Constants.HOME_PAGE_TITLE_KEY)
			.selectLotionPage();
			
		
		if(page instanceof MoisturizerPage) {
			page.selectMoisturizer(data.get("ProductContent1"))
			.selectMoisturizer(data.get("ProductContent2"))
			.goToCheckoutPage();
		} else if(page instanceof SunscreenPage) {
			page.selectSunscreen(data.get("ProductContent1"))
			.selectSunscreen(data.get("ProductContent2"));
		} else {
			page.validator(true).fail("Temperature is between 19°C to 34°C, so can not select any Lotion");
		}
		session.end();
				
	}
}
