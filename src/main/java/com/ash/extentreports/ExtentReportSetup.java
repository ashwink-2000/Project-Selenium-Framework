package com.ash.extentreports;

import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public final class ExtentReportSetup {

	private ExtentReportSetup()
	{

	}
	private static ExtentReports extent;

	public static void  initExtentReport()
	{
		if(Objects.isNull(extent))
		{
			extent=new ExtentReports();
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter("index.html");	
			extent.attachReporter(sparkReporter);
			sparkReporter.config().setTheme(Theme.DARK);
			sparkReporter.config().setDocumentTitle("Automation Test Report");
			sparkReporter.config().setReportName("Automation Test Report");
		}
	}

	public static void flushExtentReport()
	{
		if(Objects.nonNull(extent))
		{extent.flush();}
	}

	public static void createTest(String testName)
	{
		ExtentTest test=extent.createTest(testName);
		ExtentReportManager.setExtentTest(test);
	}

}
