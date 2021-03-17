package com.WeatherShopper.base.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Reporter;

import com.WeatherShopper.session.WeatherShopperTestSession;
import com.WeatherShopper.web.WebConnector;

public class WeatherShopperBasePage implements WeatherShopperPage{
	
	public WeatherShopperBasePage() {
		System.out.println("*********BasePage Constructor**********");
		PageFactory.initElements(getCurrentDriver(), this); //initialize elements
		
		getSession().setCurrentPage(this); //set the page in the session
		//getSession().takeScreenshot(); take sceenshot whenever any page opens
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

	public WebConnector validator(boolean stopExecution) {
		// update the flag in web layer
		getSession().getCon().setStopExecution(stopExecution);
		return getSession().getCon();
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
	
	public void log(String message) {
		getSession().log(message);
	}
	
	public void waitForPageToLoad() {
		JavascriptExecutor js = (JavascriptExecutor) getCurrentDriver();
		int i=1;
		
		//check for page load
		while(i!=10) {
			String state = (String) js.executeScript("return document.readyState;");
			System.out.println(state);
			if(state.equalsIgnoreCase("complete")) {
				break;
			}
			else {
				wait(2);
			}
			i++;
		}
		
		//check for jquery/ajax status
		i=1;
		while(i!=10) {
			Long d = (Long) js.executeScript("return jQuery.active;");
			System.out.println(d);
			if(d.longValue()==0) {
				break;
			}
			else {
				wait(2);
			}
			i++;
		}	
	}
	
	public void wait(int time) {
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
