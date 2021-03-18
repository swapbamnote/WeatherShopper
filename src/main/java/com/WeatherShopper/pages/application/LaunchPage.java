package com.WeatherShopper.pages.application;

import org.openqa.selenium.support.PageFactory;

import com.WeatherShopper.base.pages.WeatherShopperBasePage;
import com.WeatherShopper.base.pages.WeatherShopperPage;
import com.WeatherShopper.constants.Constants;
import com.WeatherShopper.session.WeatherShopperTestSession;

public class LaunchPage extends WeatherShopperBasePage{
	
	public WeatherShopperPage openBrowser(String browserName) {
		/*WeatherShopperTestSession session = getSession();
		session.getCon().openBrowser(browserName);*/
		
		getDriver().openBrowser(browserName);
		return this;
	}
	
	public WeatherShopperPage goToHomePage() {
		log("Navigating to Weather shopper website");
		getDriver().navigate(Constants.URL_KEY);
		return new HomePage();
	}
}
