package com.WeatherShopper.web;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Reporter;

import com.WeatherShopper.base.pages.WeatherShopperPage;
import com.WeatherShopper.constants.Constants;
import com.WeatherShopper.listener.WeatherShopperEventListener;
import com.WeatherShopper.session.WeatherShopperTestSession;

public class WeatherShopperDriver extends WeatherShopperValidationDriver{

	public WeatherShopperDriver() {
		
		try {
			prop = new Properties();
			FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+ "/src/test/resources/project.properties");
			prop.load(fs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void openBrowser(String browserName) {
		log("Opening browser "+browserName);
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver/chromedriver");
		driver = new EventFiringWebDriver(new ChromeDriver());
		driver.register(new WeatherShopperEventListener());
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	public void navigate(String urlKey) {
		log("Navigating to Weather Shopper Website "+urlKey);
		String url = prop.getProperty(urlKey);
		log("URL: "+url);
		driver.get(url);
	}

	public void quit() {
		// TODO Auto-generated method stub
		
	}
	
	public EventFiringWebDriver getCurrentDriver() {
		return driver;
	}
	
	public void waitForElementLoad() {
		
	}

	public void click(String objectKey) {
		log("Clicking on "+objectKey);
		driver.findElement(getObject(objectKey)).click();
	}
	
	public void type(String objectKey, String data) {
		log("Typing in "+objectKey+" Data "+data);
		driver.findElement(getObject(objectKey)).sendKeys(data);
	}
	
	public void clear(String objectKey) {
		driver.findElement(getObject(objectKey)).clear();
	}
	
	public String getText(String objectKey) {
		return driver.findElement(getObject(objectKey)).getText();
	}
	
	
	public List<Integer> getTemperature(String tempInfo) {
		String [] strArr = tempInfo.split("degrees.");
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
		List<Integer> priceList = new ArrayList<Integer>();
		
		for(WebElement element: pageOptions) {
			//System.out.println(element.getText());
			if(element.getText().toUpperCase().contains(lotionContent)) {
				//System.out.println(element.getText());
				List<WebElement> childElements = element.findElements(By.xpath(".//*"));
				for(int i=0; i<childElements.size(); i++) {
					//System.out.println(childElements.get(i).getText());
					if(childElements.get(i).getText().contains(Constants.PRICE_TEXT)) {
						priceList.add(Integer.parseInt(childElements.get(i).getText().replaceAll("[^0-9]", "")));
						break;
					}
				}
				
			}
		}
		System.out.println(priceList);
        Collections.sort(priceList); 
		System.out.println(priceList);
        int cheapProduct = priceList.get(0);
        //System.out.println(cheapProduct);
        for(WebElement element: pageOptions) {
        	//System.out.println(element.getText());
        	if(element.getText().toUpperCase().contains(String.valueOf(cheapProduct))) {
        		//System.out.println(element.getText());
        		return element.findElement(By.tagName(Constants.BUTTON_TAG));
        	}
        }
        return null;
	}
	
}
