package com.WeatherShopper.session;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;

import com.WeatherShopper.base.pages.WeatherShopperPage;
import com.WeatherShopper.constants.Constants;
import com.WeatherShopper.reports.ExtentManager;
import com.WeatherShopper.web.WeatherShopperDriver;
import com.WeatherShopper.web.WebConnector;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class WeatherShopperTestSession {

	//This test session HAS A webconnector
	WebConnector con;
	WeatherShopperPage currentPage; //because validate function has to return the object of current page
	ExtentReports reports;
	ExtentTest test;
	boolean executeListener;
	Hashtable<String, String> productCart;

	
	public WeatherShopperTestSession() {
		con = new WeatherShopperDriver();
	}
	public void init(String testName) {
		//setExecuteListener(true);
		if(Reporter.getCurrentTestResult().getTestContext().getAttribute("session") == null) {
			Reporter.getCurrentTestResult().getTestContext().setAttribute("session", this);
		}
		
		//init reports
		reports = ExtentManager.getReport(Constants.REPORTS_PATH);
		test = reports.createTest(testName);
		//return new LaunchPage();
	}
	
	public WebConnector getCon() {
		return con;
	}
	
	public WeatherShopperPage getCurrentPage() {
		return currentPage;
	}
	
	public void setCurrentPage(WeatherShopperPage currentPage) {
		this.currentPage = currentPage;
	}
	
	public void end() {
		getCon().assertAll();
	}
	
	/***********Reporting functions************/
	public void log(String message) {
		System.out.println(message);
		test.log(Status.INFO, message);
	}
	
	public void generateReport() {
		if(reports != null) {
			reports.flush();
		}
		// quit the browser
		if(getCon() !=null)
			getCon().quit();
		Reporter.getCurrentTestResult().getTestContext().setAttribute("session",null);
	}
	
	public void failTest(String failureMessage) {
		//fail in extent report
		test.log(Status.FAIL, failureMessage);
		//take screenshot
		takeScreenshot();
	}
	
	public void takeScreenshot() {
		// fileName of the screenshot
		Date d=new Date();
		String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
		// take screenshot
		File srcFile = ((TakesScreenshot) getCon().getCurrentDriver()).getScreenshotAs(OutputType.FILE);
		try {
			// get the dynamic folder name
			FileUtils.copyFile(srcFile, new File(ExtentManager.screenshotFolderPath+screenshotFile));
			//put screenshot file in reports
			test.log(Status.INFO,"Screenshot-> "+ test.addScreenCaptureFromPath(ExtentManager.screenshotFolderPath+screenshotFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void skipTest(String message) {
		test.log(Status.SKIP, message);
	}
	
	public boolean isExecuteListener() {
		return executeListener;
	}
	
	public void setExecuteListener(boolean executeListener) {
		this.executeListener = executeListener;
	}
	
	public Hashtable<String, String> getProductCart() {
		return productCart;
	}
	public void setProductCart(Hashtable<String, String> productCart) {
		this.productCart = productCart;
	}
	
	
	
	
	
	
	
	
	
}
