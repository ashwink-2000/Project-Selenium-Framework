package com.ash.driver;

import java.util.Objects;

import org.openqa.selenium.chrome.ChromeDriver;

import com.ash.enums.ConfigurationEnum;
import com.ash.utilites.ConfigurationUtility;

public final class Driver {

	private Driver()
	{}

	public static void initDriver()
	{
		if(Objects.isNull(DriverManager.getDriver()))
		{
			DriverManager.SetDriver(new ChromeDriver());	
			DriverManager.getDriver().get(ConfigurationUtility.getValue(ConfigurationEnum.URL));
		}	
	}

	public static void quitDriver()
	{

		if(Objects.nonNull(DriverManager.getDriver()))
		{
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}
