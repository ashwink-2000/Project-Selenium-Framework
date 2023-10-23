package com.ash.extentreports;

import com.ash.enums.ConfigurationEnum;
import com.ash.utilites.ConfigurationUtility;
import com.ash.utilites.ScreenshotUtility;
import com.aventstack.extentreports.MediaEntityBuilder;

public final class ExtentLogger {

	private ExtentLogger() {}


	public static void pass(String message)
	{
		ExtentReportManager.getExtentTest().pass(message);
	}
	public static void fail(String message)
	{
		ExtentReportManager.getExtentTest().fail(message);
	}	
	public static void skip(String message)
	{
		ExtentReportManager.getExtentTest().skip(message);
	}
	public static void info(String message)
	{
		ExtentReportManager.getExtentTest().info(message);
	}

	public static void pass(String message,boolean isScreenshotNeeded)
	{
		if (ConfigurationUtility.getValue(ConfigurationEnum.PASSEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeeded)
			ExtentReportManager.getExtentTest().pass(message,MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtility.getBase64Image()).build());
		else
			pass(message);
	}
	public static void fail(String message,boolean isScreenshotNeeded)
	{
		if (ConfigurationUtility.getValue(ConfigurationEnum.FAILEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeeded)
			ExtentReportManager.getExtentTest().fail(message,MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtility.getBase64Image()).build());
		else		
		    fail(message);
	}	
	public static void skip(String message,boolean isScreenshotNeeded)
	{
		if (ConfigurationUtility.getValue(ConfigurationEnum.SKIPPEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeeded)
			ExtentReportManager.getExtentTest().skip(message,MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtility.getBase64Image()).build());
		else		
		    skip(message);
	}
	public static void info(String message,boolean isScreenshotNeeded)
	{
		if (ConfigurationUtility.getValue(ConfigurationEnum.INFOSTEPSSCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeeded)
			ExtentReportManager.getExtentTest().info(message,MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtility.getBase64Image()).build());
		else		
			info(message);
	}
}
