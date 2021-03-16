package com.WeatherShopper.pages.application;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.WeatherShopper.base.pages.WeatherShopperBasePage;
import com.WeatherShopper.base.pages.WeatherShopperPage;
import com.WeatherShopper.constants.Constants;

public class HomePage extends WeatherShopperBasePage{
	
	public HomePage() {
		System.out.println("*********HomePage Constructor**********");
		PageFactory.initElements(getCurrentDriver(), this); //creates obj, pass the driver, initialize object but we only use 3rd capability
	}
	
	@FindBy(id=Constants.TEMPERATURE)
	WebElement temperature;
	
	@FindBy(xpath=Constants.BUY_MOISTURIZER)
	WebElement moisturizer;
	
	@FindBy(xpath=Constants.BUY_SUNSCREEN)
	WebElement sunscreen;
	
	
	public WeatherShopperPage goToMoisturizerPage() {
		moisturizer.click();
		return new MoisturizerPage();
	}
}
