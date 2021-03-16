package com.WeatherShopper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

import com.WeatherShopper.base.pages.WeatherShopperPage;
import com.WeatherShopper.listener.WeatherShopperEventListener;
import com.WeatherShopper.session.WeatherShopperTestSession;

public class ProductTypeTest {
	
	@Test
	public void chooseProductType() {
		
		WeatherShopperTestSession session = new WeatherShopperTestSession();//new driver, new browser, onesessionpertest
		WeatherShopperPage page = session.init();
		page.openBrowser("Chrome");
		
		
		/*System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver/chromedriver");
		EventFiringWebDriver driver = new EventFiringWebDriver(new ChromeDriver());
		driver.register(new WeatherShopperEventListener());
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://weathershopper.pythonanywhere.com/");*/
	}

}
