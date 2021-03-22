package com.WeatherShopper.web;

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.WeatherShopper.constants.Constants;
import com.WeatherShopper.listener.WeatherShopperEventListener;

public class WeatherShopperDriver extends WeatherShopperValidationDriver{

	public WeatherShopperDriver() {

		try {
			prop = new Properties();
			FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+ "/src/test/resources/project.properties");
			prop.load(fs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void initBrowser(String browserName) {
		log("Opening browser "+browserName);

		if(Constants.GRIDRUN.equals("Y")) {
			// desired capabilities
			DesiredCapabilities cap = new DesiredCapabilities();
			if(browserName.equalsIgnoreCase("chrome")) {
				cap.setBrowserName("chrome");
				cap.setPlatform(Platform.MAC);
			}else if(browserName.equalsIgnoreCase("firefox")) {
				cap.setBrowserName("firefox");
				cap.setPlatform(Platform.MAC);
			}

			try {
				driver = new EventFiringWebDriver(new RemoteWebDriver(new URL("http://localhost:4444"),cap));
			} catch (MalformedURLException e) {
				e.printStackTrace();
				setStopExecution(true);
				fail("Unable to launch test on hub "+ e.getMessage());
			}

		}else {
			if(browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver/chromedriver");
				//ChromeOptions opt = new ChromeOptions();
				//opt.addArguments("--disable-notifications");
				//opt.addArguments("start-maximized");
				driver = new EventFiringWebDriver(new ChromeDriver());
			}else if(browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/geckodriver/geckodriver");
				driver = new EventFiringWebDriver(new FirefoxDriver());
			}
			else if(browserName.equalsIgnoreCase("safari")) {
				driver = new EventFiringWebDriver(new SafariDriver());
			}
			

		}
		driver.register(new WeatherShopperEventListener());

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	public void navigate(String urlKey) {
		log("Navigating to Weather Shopper Website "+urlKey);
		String url = prop.getProperty(urlKey);
		log("URL: "+url);
		driver.get(url);
	}

	public void quit() {
		if(getSession().getCon().getCurrentDriver()!=null) {
			getSession().getCon().getCurrentDriver().quit();
		}
	}

	public EventFiringWebDriver getCurrentDriver() {
		return driver;
	}

	public void waitForElementLoad(String objectKey) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		By locator = getObject(objectKey);

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	public void click(String objectKey) {
		log("Clicking on "+objectKey);
		driver.findElement(getObject(objectKey)).click();
	}

	public void type(String objectKey, String data) {
		log("Typing in "+objectKey+" Data "+data);
		driver.findElement(getObject(objectKey)).sendKeys(data);
	}

	public void clear(String objectKey) {
		driver.findElement(getObject(objectKey)).clear();
	}

	public String getText(String objectKey) {
		return driver.findElement(getObject(objectKey)).getText();
	}


}
