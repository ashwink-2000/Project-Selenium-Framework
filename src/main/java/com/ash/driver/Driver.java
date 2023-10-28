package com.ash.driver;

import java.net.MalformedURLException;
import java.util.Objects;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.ash.enums.ConfigurationEnum;
import com.ash.factories.DriverFactory;
import com.ash.utilites.ConfigurationUtility;
import com.ash.exceptions.BrowserInvocationFailedException;
/**
 * 
 * @author Ashwin
 * @version 1.0
 */
public final class Driver {

	private Driver()
	{}

	public static void initDriver(String browser)
	{
		if(Objects.isNull(DriverManager.getDriver()))
		{
			try {	
				DriverManager.setDriver(DriverFactory.getDriver(browser));
			} catch (MalformedURLException e) {
				throw new BrowserInvocationFailedException("Please check the capabilities of browser");
			}
			DriverManager.getDriver().manage().window().maximize();
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
