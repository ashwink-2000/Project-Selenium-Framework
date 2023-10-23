package com.ash.listeners;

import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.ash.extentreports.ExtentLogger;
import com.ash.extentreports.ExtentReportSetup;


public class ITestAndSuiteListener implements ITestListener,ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		ExtentReportSetup.initExtentReport();	
	}

	@Override
	public void onFinish(ISuite suite) {
		ExtentReportSetup.flushExtentReport();
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentReportSetup.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getMethodName()+" is Passed");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentLogger.fail(result.getMethod().getMethodName()+" is failed",true);
		ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName()+" is skipped");
	}

}
