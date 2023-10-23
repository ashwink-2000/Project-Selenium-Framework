package com.ash.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ash.driver.DriverManager;
import com.ash.enums.WaitStrategyEnum;
import com.ash.extentreports.ExtentLogger;
import com.ash.factories.ExplicitWaitFactory;

public class BasePage {

	protected void clickElement(By by,String elementName,WaitStrategyEnum waitstrategy) {
		WebElement element=ExplicitWaitFactory.performExplicitWait(by,waitstrategy);
		element.click();
		ExtentLogger.pass(elementName+" is clicked",true);
	}

	protected void enterText(By by, String value,String elementName,WaitStrategyEnum waitstrategy) {
		WebElement element =ExplicitWaitFactory.performExplicitWait(by,waitstrategy);
		element.clear();
		element.sendKeys(value);
		ExtentLogger.pass(elementName+" is entered",true);
	}

	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}
}
