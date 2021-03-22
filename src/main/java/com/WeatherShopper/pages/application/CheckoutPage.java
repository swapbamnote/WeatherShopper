package com.WeatherShopper.pages.application;

import java.util.Hashtable;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.WeatherShopper.base.pages.WeatherShopperBasePage;
import com.WeatherShopper.base.pages.WeatherShopperPage;
import com.WeatherShopper.constants.Constants;

public class CheckoutPage extends WeatherShopperBasePage{

	public WeatherShopperPage verifyCart() {
		Hashtable<String, String> cartProducts = new Hashtable<String, String>();
		List<WebElement> cartRows = getCurrentDriver().findElements(By.xpath(Constants.CART_ROWS));
		int sumOfProductPrice = 0;
		for(int rNum=0; rNum< cartRows.size(); rNum++) {
			WebElement row = cartRows.get(rNum);
			List<WebElement> cells = row.findElements(By.xpath(Constants.CART_COLUMNS));
			
			cartProducts.put(cells.get(0).getText(), cells.get(1).getText());
			sumOfProductPrice = sumOfProductPrice + Integer.parseInt(getSession().getProductCart().get(cells.get(0).getText()));
		}
		log("Displayed products in a cart: "+cartProducts);
		log("Added products on a lotion page: "+getSession().getProductCart());
		if(!cartProducts.equals(getSession().getProductCart())) {
			fail("Cart do not match, Expected Cart: "+getSession().getProductCart()+ "Displayed Cart: "+cartProducts);
		}
		String total = getCurrentDriver().findElement(By.xpath(Constants.TOTAL_PRICE)).getText();
		int totalPrice = Integer.parseInt(total.replaceAll("[^0-9]", ""));
		if(sumOfProductPrice != totalPrice) {
			fail("Total price do not match, got total price as "+sumOfProductPrice+"Cart Total shown as "+totalPrice);
		}
		return this;
	}
	
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
