package com.WeatherShopper.constants;

import org.openqa.selenium.By;

public class Constants {
	
	public static final String GRIDRUN = "N";
	
	public static final String BUY_MOISTURIZER = "//a[@href='/moisturizer']";
	public static final By BUY_MOISTURIZER_LOCATOR = By.xpath(BUY_MOISTURIZER);
	
	public static final String BUY_SUNSCREEN = "//a[@href='/sunscreen']";
	public static final By BUY_SUNSCREEN_LOCATOR = By.xpath(BUY_SUNSCREEN);

	
	public static final String HOME_PAGE_TEXT = "h2";
	public static final By HOME_PAGE_TEXT_LOCATOR = By.tagName(HOME_PAGE_TEXT);
	
	public static final String INFO = "//span[@class='octicon octicon-info']";
	public static final By INFO_LOCATOR = By.xpath(INFO);
	
	public static final String CURRENT_TEMPERATURE = "temperature";
	public static final By CURRENT_TEMPERATURE_LOCATOR = By.id(CURRENT_TEMPERATURE);
	
	public static final String DIV_FIRST_ROW = "//body/div[@class='container']/div[2]/div";
	public static final By DIV_FIRST_ROW_LOCATOR = By.xpath(DIV_FIRST_ROW);
	
	public static final String DIV_SECOND_ROW = "//body/div[@class='container']/div[3]/div";
	public static final By DIV_SECOND_ROW_LOCATOR = By.xpath(DIV_SECOND_ROW);
	
	public static final String All_PRODUCTS = "//body/div[@class='container']/div/div";
	public static final By All_PRODUCTS_LOCATOR = By.xpath(DIV_SECOND_ROW);
	
	public static final String GoTo_CHECKOUT_BUTTON = "//button[@onClick='goToCart()']";
	public static final By GoTo_CHECKOUT_BUTTON_LOCATOR = By.xpath(GoTo_CHECKOUT_BUTTON);
	
	public static final String PAY_WITH_CARD_BUTTON = "button[type='submit']";
	public static final By PAY_WITH_CARD_BUTTON_LOCATOR = By.cssSelector(PAY_WITH_CARD_BUTTON);
	
	public static final String EMAIL = "//input[@type='email']";
	public static final By EMAIL_LOCATOR = By.xpath(EMAIL);
	
	public static final String CC_NUMBER = "//input[@placeholder='Card number']";
	public static final By CC_NUMBER_LOCATOR = By.xpath(CC_NUMBER);
	
	public static final String CC_EXPIRY_DATE = "//input[@placeholder='MM / YY']";
	public static final By CC_EXPIRY_DATE_LOCATOR = By.xpath(CC_EXPIRY_DATE);
	
	public static final String CC_CVV = "//input[@placeholder='CVC']";
	public static final By CC_CVV_LOCATOR = By.xpath(CC_CVV);
	
	public static final String CC_ZIP_CODE = "//input[@placeholder='ZIP Code']";
	public static final By CC_ZIP_CODE_LOCATOR = By.xpath(CC_ZIP_CODE);
	
	public static final String MAKE_PAYMENT_BUTTON = "//div[@class='Section-button']/button";
	public static final By MAKE_PAYMENT_BUTTON_LOCATOR = By.xpath(MAKE_PAYMENT_BUTTON);
	
	public static final String PRICE_TEXT = "PRICE";
	public static final String BUTTON_TAG ="button";
	public static final String TEMPERATURE_STRING_SPLIT = "degrees.";
	public static final String CART_ROWS = "//tbody/tr";
	public static final String CART_COLUMNS = "td";
	public static final String IFRAME = "iframe";
	public static final String PRODUCT_PRICE_CHILD = "child::p[2]";
	public static final String PRODUCT_NAME_CHILD = "child::p[1]";
	public static final String TOTAL_PRICE = "//p[@id='total']";
	public static final String MOISURIZER = "Moisturizers";
	public static final String SUNSCREEN = "Sunscreens";
	
	public static final String PAYMENT_RESULT_PAGE_TEXT = "//h2[text()='PAYMENT SUCCESS']";
	public static final By PAYMENT_RESULT_PAGE_LOCATOR = By.xpath(HOME_PAGE_TEXT);

	public static final String PAYMENT_SUCCESS_TEXT = "PAYMENT SUCCESS";
	public static final String PAYMENT_FAILED_TEXT = "PAYMENT FAILED";
	
	public static final String HOME_PAGE_TITLE = "Current Temperature";
	
	public static final String REPORTS_PATH = System.getProperty("user.dir")+"/reports/";
	
	// sheet names
	public static final String TEST_STATUS_SHEET = "TestStatus";
	
	//col names
	public static final String TCID = "TCID";
	public static final String RUNMODE = "Runmode";

	//Keys
	public static final String URL_KEY = "url";
	public static final String HOME_PAGE_TITLE_KEY = "homepage_title";
	public static final String HOME_PAGE_TEXT_KEY = "homepage_text_tagName";
	public static final String CURRENT_TEMPERATURE_KEY = "current_temperature_id";
	public static final String MOISTURIZER_TEXT_KEY = "moisturizer_text_xpath";
	public static final String SUNSCREEN_TEXT_KEY = "sunscreen_text_xpath";
	public static final String BUY_MOISTURIZER_KEY = "moisturizer_xpath";
	public static final String BUY_SUNSCREEN_KEY = "sunscreen_xpath";
	public static final String GoTo_CHECKOUT_BUTTON_KEY = "go_to_checkout_button_xpath";
	public static final String PAY_WITH_CARD_BUTTON_KEY = "pay_with_card_button_css";
	public static final String EMAIL_KEY = "email_xpath";
	public static final String CC_NUMBER_KEY = "cc_number_xpath";
	public static final String CC_EXPIRY_DATE_KEY = "cc_expiry_date_xpath";
	public static final String CC_CVV_KEY = "cc_cvv_xpath";
	public static final String CC_ZIP_CODE_KEY = "cc_zip_xpath";
	public static final String MAKE_PAYMENT_BUTTON_KEY = "make_payment_xpath";
	public static final String PAYMENT_RESULT_PAGE_TEXT_KEY = "payment_result_xpath";
	public static final String All_PRODUCTS_KEY = "all_products_xpath";
	public static final String CART_ROWS_KEY = "cart_rows_xpath";
	public static final String CART_COLUMNS_KEY = "cart_columns_tagName";

}
