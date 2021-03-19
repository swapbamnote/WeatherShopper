package com.WeatherShopper.pages.application;

import com.WeatherShopper.base.pages.WeatherShopperBasePage;
import com.WeatherShopper.base.pages.WeatherShopperPage;
import com.WeatherShopper.constants.Constants;

public class PaymentConfirmationPage extends WeatherShopperBasePage{

	public WeatherShopperPage getPaymentConfirmation() {
		waitForPageToLoad();
		String paymentStatus = getDriver().getText(Constants.PAYMENT_RESULT_PAGE_TEXT_KEY);
		
		log("Payment status is "+paymentStatus);
		return this;
	}
	
}
