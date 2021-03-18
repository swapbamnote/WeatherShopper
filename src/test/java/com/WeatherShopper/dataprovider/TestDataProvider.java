package com.WeatherShopper.dataprovider;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import com.WeatherShopper.util.DataUtil;
import com.WeatherShopper.util.Xls_Reader;

public class TestDataProvider {

	static Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir")+"//Data.xlsx");

	
	@DataProvider
	public static Object[][] getData(Method m) {
		
		return DataUtil.getData(m.getName(), xls);
	}
}
