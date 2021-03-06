package com.WeatherShopper.pages.application;

import com.WeatherShopper.base.pages.WeatherShopperBasePage;
import com.WeatherShopper.base.pages.WeatherShopperPage;
import com.WeatherShopper.constants.Constants;

public class LaunchPage extends WeatherShopperBasePage{

	// open browser
	public WeatherShopperPage openBrowser(String browserName) {
		/*WeatherShopperTestSession session = getSession();
		session.getCon().openBrowser(browserName);*/

		getDriver().initBrowser(browserName);
		return this;
	}

	// open weather shopper website
	public WeatherShopperPage goToHomePage() {
		log("Navigating to Weather shopper website");
		getDriver().navigate(Constants.URL_KEY);
		return new HomePage();
	}
}
