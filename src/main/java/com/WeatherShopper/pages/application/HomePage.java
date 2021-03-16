package com.WeatherShopper.pages.application;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.WeatherShopper.base.pages.WeatherShopperBasePage;
import com.WeatherShopper.base.pages.WeatherShopperPage;
import com.WeatherShopper.constants.Constants;

public class HomePage extends WeatherShopperBasePage{
	
	
	
	
	public WeatherShopperPage goToMoisturizerPage() {
		
		return new MoisturizerPage();
	}
}
