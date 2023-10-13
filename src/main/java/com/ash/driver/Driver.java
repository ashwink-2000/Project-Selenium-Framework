package com.ash.driver;

import org.openqa.selenium.chrome.ChromeDriver;

import com.ash.enums.ConfigurationEnum;
import com.ash.utilites.ConfigurationUtility;

public final class Driver {
	
	private Driver()
	{}
	
	public static void initDriver()
	{
		DriverManager.SetDriver(new ChromeDriver());	
		DriverManager.getDriver().get(ConfigurationUtility.getValue(ConfigurationEnum.URL));
	}
	
	public static void quitDriver()
	{
		DriverManager.getDriver().quit();
	}
}
