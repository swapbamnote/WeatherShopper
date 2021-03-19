package com.WeatherShopper.constants;

import org.openqa.selenium.By;

public class Constants {
	
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
	
	public static final String GoTo_CART_BUTTON = "//button[@onClick='goToCart()']";
	public static final By GoTo_CART_BUTTON_LOCATOR = By.cssSelector(GoTo_CART_BUTTON);
	
	public static final String PAY_BUTTON = "button[type='submit']";
	public static final By PAY_BUTTON_LOCATOR = By.cssSelector(PAY_BUTTON);
	
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
	public static final String BUY_MOISTURIZER_KEY = "moisturizer_xpath";
	public static final String BUY_SUNSCREEN_KEY = "sunscreen_xpath";
	public static final String GoTo_CART_BUTTON_KEY = "go_to_cart_button_xpath";
	public static final String PAY_BUTTON_KEY = "pay_button_css";


}
