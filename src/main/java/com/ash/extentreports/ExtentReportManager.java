package com.ash.extentreports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentReportManager {

	private ExtentReportManager()
	{

	}

	private static ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();

	public static ExtentTest getExtentTest(){

		return extentTest.get();
	}

	public static void setExtentTest(ExtentTest ExtentTestRef)
	{
		extentTest.set(ExtentTestRef);
	}
	
	public static void unload()
	{
		extentTest.remove();
	}
}
