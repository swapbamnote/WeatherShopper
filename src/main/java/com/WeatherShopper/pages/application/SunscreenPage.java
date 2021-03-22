package com.WeatherShopper.pages.application;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;

import com.WeatherShopper.base.pages.WeatherShopperBasePage;
import com.WeatherShopper.base.pages.WeatherShopperPage;
import com.WeatherShopper.constants.Constants;

public class SunscreenPage extends WeatherShopperBasePage{

	@FindAll({
		 @FindBy(xpath = Constants.DIV_FIRST_ROW), 
		 @FindBy(xpath = Constants.DIV_SECOND_ROW),
	})
	public List<WebElement> pageOptions;
	
	public WeatherShopperPage selectSunscreen(String productContent) {
		System.out.println(pageOptions);
		waitForPageToLoad();
		//List<WebElement> pageOptions = getCurrentDriver().findElements(By.xpath(Constants.All_PRODUCTS));
		log("Number of products displayed: " +pageOptions.size());
		WebElement productToBeAdded = addToCart(pageOptions,productContent);
		if(productToBeAdded!=null) {
			log("Product to be added in the cart: "+productToBeAdded.getText());
			productToBeAdded.findElement(By.tagName(Constants.BUTTON_TAG)).click();
		}
		else {
			this.validator(true).fail("No matching product found");
		}
		
		return this;
	}
	
	public WeatherShopperPage goToCheckoutPage() {
		log("Navigating to Checkout page");
		getDriver().click(Constants.GoTo_CHECKOUT_BUTTON_KEY);
		return new CheckoutPage();
	}
}
