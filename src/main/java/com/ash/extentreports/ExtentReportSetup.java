package com.ash.extentreports;

import java.util.Objects;

import com.ash.enums.CategoryType;
import com.ash.frameworkconstants.FrameworkConstants;
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
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(FrameworkConstants.getExtentReportPath());	
			extent.attachReporter(sparkReporter);
			sparkReporter.config().setTheme(Theme.DARK);
			sparkReporter.config().setDocumentTitle("Automation Test Report");
			sparkReporter.config().setReportName("Automation Test Report");
		}
	}

	public static void flushExtentReport()
	{
		if(Objects.nonNull(extent))
		{
			extent.flush();
			ExtentReportManager.unload();
		}
	}

	public static void createTest(String testName)
	{
		ExtentTest test=extent.createTest(testName);
		ExtentReportManager.setExtentTest(test);
	}
	
	public static void addAuthors(String [] authors)
	{
		for(String author:authors)
		{
			ExtentReportManager.getExtentTest().assignAuthor(author);
		}
	}
	public static void addCategories(CategoryType[] categoryTypes)
	{
		for(CategoryType category:categoryTypes)
		{
			ExtentReportManager.getExtentTest().assignCategory(category.toString());
		}
	}
}
