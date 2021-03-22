package com.WeatherShopper.base.pages;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Reporter;

import com.WeatherShopper.constants.Constants;
import com.WeatherShopper.session.WeatherShopperTestSession;
import com.WeatherShopper.web.WebConnector;

public class WeatherShopperBasePage implements WeatherShopperPage{
	Hashtable<String, String> prodTable = new Hashtable<String, String>();

	public WeatherShopperBasePage() {
		System.out.println("*********BasePage Constructor**********");
		PageFactory.initElements(getCurrentDriver(), this); //initialize elements

		getSession().setCurrentPage(this); //set the page in the session
		//getSession().takeScreenshot(); take sceenshot whenever any page opens
	}

	public WeatherShopperPage openBrowser(String browserName) {
		return null; //avoid implementation
	}

	public WeatherShopperPage goToHomePage() {
		return null;
	}

	public WeatherShopperPage selectLotionPage() {
		return null;
	}
	public WeatherShopperPage selectMoisturizer(String productContent) {
		return null;
	}
	public WeatherShopperPage selectSunscreen(String productContent) {
		return null;
	}
	public WeatherShopperPage addPaymentDetails(String email, String ccNum, String expiryDate, String cvv, String zipCode) {
		return null;
	}
	public WeatherShopperPage getPaymentConfirmation() {
		return null;
	}

	public WeatherShopperPage verifyCart() {
		return null;
	}

	public WeatherShopperPage goToCheckoutPage() {
		return null;
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

	public void fail(String message) { getSession().getCon().fail(message); };

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
		/*i=1;
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
		}*/
	}

	public void wait(int time) {
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	public List<Integer> getTemperature(String tempInfo) {
		String [] strArr = tempInfo.split(Constants.TEMPERATURE_STRING_SPLIT);
		int n=0;

		List<Integer> tempArray = new ArrayList<Integer>();

		for(int i=0; i<strArr.length; i++) {
			String num = strArr[i].replaceAll("[^0-9]", "");
			n = Integer.parseInt(num);
			tempArray.add(n);
		}
		return tempArray;
	}

	public WebElement addToCart(List<WebElement> pageOptions, String lotionContent) {
		Hashtable<Integer, String> productsTable = new Hashtable<Integer, String>();
		getSession().setExecuteListener(false);
		for(WebElement element: pageOptions) {
			if(element.getText().toUpperCase().contains(lotionContent)) {
				int productPrice = Integer.parseInt(element.findElement(By.xpath(Constants.PRODUCT_PRICE_CHILD)).getText().replaceAll("[^0-9]", ""));
				String productName = element.findElement(By.xpath(Constants.PRODUCT_NAME_CHILD)).getText();
				productsTable.put(productPrice, productName);
			}
		}
		getSession().setExecuteListener(true);

		TreeMap<Integer, String> tm = new TreeMap<Integer, String>(productsTable);
		Set<Integer> keys = tm.keySet();
	    Iterator<Integer> itr = keys.iterator();
		Integer it = itr.next();

        prodTable.put(tm.get(it),String.valueOf(it));
        getSession().setProductCart(prodTable);
        for(WebElement element: pageOptions) {
        	if(element.getText().toUpperCase().contains(String.valueOf(it))) {
        		//return element.findElement(By.tagName(Constants.BUTTON_TAG));
        		return element;
        	}
        }
        return null;
	}
}
