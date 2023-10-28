package com.ash.factories;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.ash.enums.ConfigurationEnum;
import com.ash.utilites.ConfigurationUtility;


public final class DriverFactory {

	private DriverFactory()
	{

	}

	public static WebDriver getDriver(String browser) throws MalformedURLException
	{
		WebDriver driver =null;
		String runmode=ConfigurationUtility.getValue(ConfigurationEnum.RUNMODE);
		if(browser.equalsIgnoreCase("chrome"))	
		{
			if(runmode.equalsIgnoreCase("remote"))
			{   
//				DesiredCapabilities cap =new DesiredCapabilities();
//				cap.setBrowserName("chrome");
//				driver =new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
				ChromeOptions coptions = new ChromeOptions();
				coptions.setCapability("browserVersion", "118.0");
				coptions.setCapability("selenoid:options", new HashMap<String, Object>() {{
				    put("name", "ChromeTest");
				    put("enableVideo", true);
				    put("enableVNC", true);
				    put("videoName","ChromeTest.mp4");
				}});
				 driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), coptions);
			
			}
			else
				driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			if(runmode.equalsIgnoreCase("remote"))
			{
//				DesiredCapabilities cap =new DesiredCapabilities();
//				cap.setBrowserName("firefox");
				FirefoxOptions foptions = new FirefoxOptions();
				foptions.setCapability("browserVersion", "118.0");
				foptions.setCapability("selenoid:options", new HashMap<String, Object>() {{
				    put("name", "FireFoxTest");
				    put("enableVideo", true);
				    put("enableVNC", true);
				    put("videoName","fireFoxTest.mp4");
				}});
				driver =new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),foptions);

			}
			else
				driver =new FirefoxDriver();
		}
		return driver;

	}
}
