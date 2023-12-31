package com.ash.tests;
import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.ash.driver.Driver;

public class BaseTest {
	protected BaseTest() 
	{}
	@SuppressWarnings("unchecked")
	@BeforeMethod
    protected void initDriver(Object[] data) 
	{
	
		Map<String,String> map =(Map<String,String>)data[0];
		Driver.initDriver(map.get("browser"));
	}

	@AfterMethod
	protected void quitDriver()
	{
		Driver.quitDriver();
	}

}

