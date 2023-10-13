package com.ash.driver;

import org.openqa.selenium.chrome.ChromeDriver;

public final class Driver {
	
	private Driver()
	{}
	
	protected static void initDriver()
	{
		DriverManager.SetDriver(new ChromeDriver());	
		DriverManager.getDriver().get("https://www.google.com");
	}
	
	protected static void quitDriver()
	{
		DriverManager.getDriver().quit();
	}
}
