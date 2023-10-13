package com.ash.driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {


	private static ThreadLocal<WebDriver> dr= new ThreadLocal<WebDriver>();
	
	public static WebDriver getDriver()
	{
		return dr.get();
	}
	
	public static void SetDriver(WebDriver WebDriverRef)
	{
		dr.set(WebDriverRef);
	}
	
	public static void unload()
	{
		dr.remove();
	}
	
}
