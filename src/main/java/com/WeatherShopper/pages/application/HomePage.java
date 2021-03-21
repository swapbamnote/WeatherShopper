package com.WeatherShopper.pages.application;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.WeatherShopper.base.pages.WeatherShopperBasePage;
import com.WeatherShopper.base.pages.WeatherShopperPage;
import com.WeatherShopper.constants.Constants;

public class HomePage extends WeatherShopperBasePage{
		
	public WeatherShopperPage selectLotionPage() {
		waitForPageToLoad();
		String temperatureInfo = getCurrentDriver().findElement(By.xpath(Constants.INFO)).getAttribute("data-content");
		List<Integer> temperatures = getTemperature(temperatureInfo);
		
		int maxTemp = Math.max(temperatures.get(0), temperatures.get(1));
		int minTemp = Math.min(temperatures.get(0), temperatures.get(1));
		
		String currentTemp = getDriver().getText(Constants.CURRENT_TEMPERATURE_KEY).replaceAll("[^0-9]", "");
		log("Current temperature displayed: "+currentTemp);
		
		if(Integer.parseInt(currentTemp) < minTemp) {
			getDriver().click(Constants.BUY_MOISTURIZER_KEY);
			log("Going to Moisturizer page");
			return new MoisturizerPage();
		}
		else if(Integer.parseInt(currentTemp) > maxTemp) {
			getDriver().click(Constants.BUY_SUNSCREEN_KEY);
			log("Going to Sunscreen page");
			return new SunscreenPage();
		}
		else {
			return this;
		}
	}
}
