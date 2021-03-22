package com.WeatherShopper.base.pages;

import java.util.List;
import org.openqa.selenium.WebElement;

public interface WeatherShopperApplicationPage {

	//application functions
	WeatherShopperPage goToHomePage();
	WeatherShopperPage selectLotionPage();
	WeatherShopperPage selectMoisturizer(String productContent);
	WeatherShopperPage selectSunscreen(String productContent);
	WeatherShopperPage goToCheckoutPage();
	WeatherShopperPage verifyCart();
	WeatherShopperPage addPaymentDetails(String email, String ccNum, String expiryDate, String cvv, String zipCode);
	WeatherShopperPage getPaymentConfirmation();
	List<Integer> getTemperature(String tempContent);
	WebElement addToCart(List<WebElement> pageOptions, String lotionContent);
}
