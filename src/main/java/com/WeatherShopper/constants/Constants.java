package com.WeatherShopper.constants;

import org.openqa.selenium.By;

public class Constants {

	
	public static final String TEMPERATURE = "temperature";
	
	public static final String BUY_MOISTURIZER = "//a[@href='/moisturizer']";
	public static final By BUY_MOISTURIZER_LOCATOR = By.xpath(BUY_MOISTURIZER);
	
	public static final String BUY_SUNSCREEN = "//a[@href='/sunscreen']";
	public static final By BUY_SUNSCREEN_LOCATOR = By.xpath(BUY_SUNSCREEN);

	
	public static final String HOME_PAGE_TEXT = "h2";
	public static final By HOME_PAGE_TEXT_LOCATOR = By.tagName(HOME_PAGE_TEXT);
	
	public static final String HOME_PAGE_TITLE = "Current Temperature";
	
	public static final String REPORTS_PATH = System.getProperty("user.dir")+"//reports//";
	
	
	// sheet names
	public static final String TEST_STATUS_SHEET = "Test Status";
	
	//col names
	public static final String TCID = "TCID";
	public static final String RUNMODE = "Runmode";

	//Keys
	public static final String URL_KEY = "key";
	public static final String BUY_MOISTURIZER_KEY = "moisturizer_xpath";
	public static final String HOME_PAGE_TITLE_KEY = "homepage_title";
	public static final String HOME_PAGE_TEXT_KEY = "homepage_text_tagName";



}
