package com.WeatherShopper.pages.application;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.WeatherShopper.base.pages.WeatherShopperBasePage;
import com.WeatherShopper.base.pages.WeatherShopperPage;
import com.WeatherShopper.constants.Constants;

public class CheckoutPage extends WeatherShopperBasePage{

	public WeatherShopperPage addPaymentDetails() {
		waitForPageToLoad();
		getDriver().click(Constants.PAY_WITH_CARD_BUTTON_KEY);
		List<WebElement> frames = getCurrentDriver().findElements(By.tagName("iframe"));
		//System.out.println("Number of frames "+ frames.size());
		for(int i=0; i<frames.size(); i++) {
			getCurrentDriver().switchTo().frame(i);
			if(getCurrentDriver().findElements(By.xpath(Constants.EMAIL)).size()==0) {
				getCurrentDriver().switchTo().defaultContent();
			}
			else {
				break;
			}
		}
		
		getDriver().type(Constants.EMAIL_KEY, "swapbamnote@gmail.com");
		getDriver().type(Constants.CC_NUMBER_KEY, "4242424242424242");
		getDriver().type(Constants.CC_EXPIRY_DATE_KEY, "0923");
		if(getCurrentDriver().findElements(By.xpath(Constants.CC_ZIP_CODE)).size() > 0) {
			getDriver().type(Constants.CC_ZIP_CODE_KEY , "0923");
		}
		getDriver().click(Constants.MAKE_PAYMENT_BUTTON_KEY);
		getCurrentDriver().switchTo().defaultContent();
		return new PaymentSuccessPage();
	}
}
