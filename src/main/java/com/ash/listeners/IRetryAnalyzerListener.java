package com.ash.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.ash.enums.ConfigurationEnum;
import com.ash.utilites.ConfigurationUtility;

public class IRetryAnalyzerListener implements IRetryAnalyzer {

	private int count=0;
	private int retry=1; 
	@Override
	public boolean retry(ITestResult result) {
		boolean value=false;
		if(ConfigurationUtility.getValue(ConfigurationEnum.RETRYFAILEDTESTS).equalsIgnoreCase("yes"))
		{
			value=count<retry;
			count++;
		}
		return value;
	}

}
