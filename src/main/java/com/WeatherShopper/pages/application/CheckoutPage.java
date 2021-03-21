package com.WeatherShopper.pages.application;

import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.WeatherShopper.base.pages.WeatherShopperBasePage;
import com.WeatherShopper.base.pages.WeatherShopperPage;
import com.WeatherShopper.constants.Constants;

public class CheckoutPage extends WeatherShopperBasePage{

	public WeatherShopperPage addPaymentDetails(String email, String ccNum, String expiryDate, String cvv, String zipCode) {
		waitForPageToLoad();
		
		getDriver().click(Constants.PAY_WITH_CARD_BUTTON_KEY);
		List<WebElement> frames = getCurrentDriver().findElements(By.tagName(Constants.IFRAME));
		for(int i=0; i<frames.size(); i++) {
			getCurrentDriver().switchTo().frame(i);
			if(getCurrentDriver().findElements(By.xpath(Constants.EMAIL)).size()==0) {
				getCurrentDriver().switchTo().defaultContent();
			}
			else {
				break;
			}
		}
		getDriver().type(Constants.EMAIL_KEY, email);
		getDriver().type(Constants.CC_NUMBER_KEY, ccNum);
		getDriver().type(Constants.CC_EXPIRY_DATE_KEY, expiryDate);
		getDriver().type(Constants.CC_CVV_KEY, cvv);
		if(getCurrentDriver().findElements(By.xpath(Constants.CC_ZIP_CODE)).size() > 0) {
			getDriver().type(Constants.CC_ZIP_CODE_KEY , zipCode);
		}
		getDriver().click(Constants.MAKE_PAYMENT_BUTTON_KEY);
		getCurrentDriver().switchTo().defaultContent();
		return new PaymentConfirmationPage();
	}
}
