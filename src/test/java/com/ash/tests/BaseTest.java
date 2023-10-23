package com.ash.tests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.ash.driver.Driver;

public class BaseTest {
	protected BaseTest() 
	{}
	
	@BeforeMethod
    protected void initDriver() 
	{
		Driver.initDriver();
	}

	@AfterMethod
	protected void quitDriver()
	{
		Driver.quitDriver();
	}

}

