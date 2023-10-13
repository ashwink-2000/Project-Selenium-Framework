package com.ash.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ash.enums.WaitStrategyEnum;
import com.ash.factories.ExplicitWaitFactory;

public class BasePage {

	protected void clickElement(By by,String elementname,WaitStrategyEnum waitstrategy) {
		WebElement element =ExplicitWaitFactory.performExplicitWait(by,waitstrategy);
		element.click();
	}
	
	protected void EnterText(By by, String value,WaitStrategyEnum waitstrategy) {
		WebElement element =ExplicitWaitFactory.performExplicitWait(by,waitstrategy);
		element.clear();
		element.sendKeys(value);
	}
}
