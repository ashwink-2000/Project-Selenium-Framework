package com.ash.frameworkconstants;

import java.time.Duration;

import com.ash.enums.ConfigurationEnum;
import com.ash.utilites.ConfigurationUtility;

public final class FrameworkConstants {

	private FrameworkConstants()
	{}

	private static final String TESTRESOURCESPATH=System.getProperty("user.dir")+"/src/test/resources/";

	//Enter explicit wait time value
	private static final Duration EXPLICITWAITTIME=Duration.ofSeconds(10);

	//Enter Configuration file path 
	private static final String CONFIGURATIONFILEPATH=TESTRESOURCESPATH+"configuration/configuration.properties";
	//Excel sheet name value
	private static final String EXCELSHEETNAME = "testdatafile";
	//Enter Excel sheet path 
	private static final String EXCELPATH =TESTRESOURCESPATH+"exceldatasheet/"+EXCELSHEETNAME+".xlsx";
	//Enter excel sheet name value
	private static final String RUNMANGERSHEET ="runmanager";
	private static final String DATASHEET = "testdata";
	
	//Enter extent Report path 
	private static final String EXTENTREPORTFOLDER=System.getProperty("user.dir")+"/extent-reports/";
	private static String extentReportPath="";


	private static String createExtentReportPath()
	{
		if(ConfigurationUtility.getValue(ConfigurationEnum.OVERRIDEEXTENTREPORTS).equalsIgnoreCase("no"))
			return EXTENTREPORTFOLDER+System.currentTimeMillis()+"index.html";
		else
			return EXTENTREPORTFOLDER+"index.html";
	}

	public static String getExtentReportPath()
	{
		if(extentReportPath.isEmpty())
		{extentReportPath=createExtentReportPath();}
		return extentReportPath;
	}
	
	public static String configurationFilePath()
	{
		return CONFIGURATIONFILEPATH;
	}
	public static String getExcelPath()
	{
		return EXCELPATH;
	}

	public static String getRunManagerSheetName()
	{
		return RUNMANGERSHEET;
	}

	public static String getDataSheetName()
	{
		return DATASHEET;
	}

	public static Duration getExplicitWaitTime()
	{
		return EXPLICITWAITTIME;
	}
}
