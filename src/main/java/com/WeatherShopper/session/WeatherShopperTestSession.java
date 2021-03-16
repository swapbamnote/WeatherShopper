package com.WeatherShopper.session;

import org.testng.Reporter;

import com.WeatherShopper.base.pages.WeatherShopperPage;
import com.WeatherShopper.pages.application.LaunchPage;

public class WeatherShopperTestSession {

	public WeatherShopperPage init() {
		if(Reporter.getCurrentTestResult().getTestContext().getAttribute("session") == null) {
			Reporter.getCurrentTestResult().getTestContext().setAttribute("session", this);
		}
		
		return new LaunchPage();
	}
}
