package com.WeatherShopper.pages.application;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.WeatherShopper.base.pages.WeatherShopperBasePage;
import com.WeatherShopper.base.pages.WeatherShopperPage;
import com.WeatherShopper.constants.Constants;

public class HomePage extends WeatherShopperBasePage{
		
	/*@FindBy(id=Constants.TEMPERATURE)
	WebElement temperature;
	
	@FindBy(xpath=Constants.BUY_MOISTURIZER)
	WebElement moisturizer;
	
	@FindBy(xpath=Constants.BUY_SUNSCREEN)
	WebElement sunscreen;
	*/
	
	public WeatherShopperPage goToMoisturizerPage() {
		waitForPageToLoad();
		getDriver().click(Constants.BUY_MOISTURIZER_KEY);
		log("Going to Moisturizer page");
		return new MoisturizerPage();
	}
}
