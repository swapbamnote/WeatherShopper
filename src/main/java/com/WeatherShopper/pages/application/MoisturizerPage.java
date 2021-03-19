package com.WeatherShopper.pages.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.WeatherShopper.base.pages.WeatherShopperBasePage;
import com.WeatherShopper.base.pages.WeatherShopperPage;
import com.WeatherShopper.constants.Constants;

public class MoisturizerPage extends WeatherShopperBasePage {
	@FindAll({
		 @FindBy(xpath = Constants.DIV_FIRST_ROW), 
		 @FindBy(xpath = Constants.DIV_SECOND_ROW),
	})
	public List<WebElement> pageOptions;
	
	public WeatherShopperPage selectMoisturizer(String productContent) {
		waitForPageToLoad();
		log("Number of products displayed: " +pageOptions.size());
		List<Integer> priceList = new ArrayList<Integer>();
		
		for(WebElement element: pageOptions) {
			if(element.getText().contains(productContent)) {
				priceList.add(Integer.parseInt(element.getText().replaceAll("[^0-9]", "")));
			}
		}
        Collections.sort(priceList); 
        int leastMoisturizer = priceList.get(0);
        for(WebElement element: pageOptions) {
        	if(element.getText().contains(String.valueOf(leastMoisturizer))) {
        		log("Product to be added in the cart: "+element.getText());
        		element.findElement(By.tagName("button")).click();
        	}
        }
		return this;
	}
	
	public WeatherShopperPage goToCheckoutPage() {
		log("Navigating to Checkout page");
		getDriver().click(Constants.GoTo_CART_BUTTON_KEY);
		return new CheckoutPage();
	}
}
