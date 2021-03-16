package com.WeatherShopper.session;

import org.testng.Reporter;

import com.WeatherShopper.base.pages.WeatherShopperPage;
import com.WeatherShopper.pages.application.LaunchPage;
import com.WeatherShopper.web.WeatherShopperDriver;
import com.WeatherShopper.web.WebConnector;

public class WeatherShopperTestSession {

	//This test session HAS A webconnector
	WebConnector con;
	WeatherShopperPage currentPage; //because validate function has to return the object of current page
	
	public WeatherShopperTestSession() {
		con = new WeatherShopperDriver();
	}
	public WeatherShopperPage init() {
		if(Reporter.getCurrentTestResult().getTestContext().getAttribute("session") == null) {
			Reporter.getCurrentTestResult().getTestContext().setAttribute("session", this);
		}
		
		return new LaunchPage();
	}
	
	public WebConnector getCon() {
		return con;
	}
	
	public WeatherShopperPage getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(WeatherShopperPage currentPage) {
		this.currentPage = currentPage;
	}
}
