package com.ash.utilites;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.ash.driver.DriverManager;

public final class ScreenshotUtility {

	private ScreenshotUtility()
	{}

	public static String getBase64Image()
	{
		return ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}
}
