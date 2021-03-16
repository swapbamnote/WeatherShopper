package com.WeatherShopper.base.pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Reporter;

import com.WeatherShopper.session.WeatherShopperTestSession;
import com.WeatherShopper.web.WebConnector;

public class WeatherShopperBasePage implements WeatherShopperPage{
	
	public WeatherShopperBasePage() {
		System.out.println("*********HomePage Constructor**********");
		PageFactory.initElements(getCurrentDriver(), this); //creates obj, pass the driver, initialize object but we only use 3rd capability
	}

	public WeatherShopperPage openBrowser(String browserName) {
		return null; //avoid implementation
	}

	public void quit() {
		// TODO Auto-generated method stub
		
	}

	public void getTotalWindows() {
		// TODO Auto-generated method stub
		
	}

	public WeatherShopperPage goToHomePage() {
		return null;
	}

	public WeatherShopperPage goToMoisturizerPage() {
		return null;
		
	}

	public void goToSunscreenPage() {
		// TODO Auto-generated method stub
		
	}

	public void goToCheckoutPage() {
		// TODO Auto-generated method stub
		
	}

	public void validator() {
		// TODO Auto-generated method stub
		
	}
	
	public WeatherShopperTestSession getSession() {
		return (WeatherShopperTestSession) Reporter.getCurrentTestResult().getTestContext().getAttribute("session");
	}

	public WebConnector getDriver() {
		return getSession().getCon();
	}

	public EventFiringWebDriver getCurrentDriver() {
		return getSession().getCon().getCurrentDriver();
	}

}
