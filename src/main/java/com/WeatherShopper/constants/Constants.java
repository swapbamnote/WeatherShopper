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



}
