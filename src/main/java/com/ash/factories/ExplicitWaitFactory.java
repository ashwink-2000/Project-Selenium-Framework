package com.ash.factories;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ash.driver.DriverManager;
import com.ash.enums.WaitStrategyEnum;

public final class ExplicitWaitFactory {

	private ExplicitWaitFactory()
	{
		
	}
	
	public static WebElement performExplicitWait(By by,WaitStrategyEnum waitStrategy)
	{
		WebElement element=null;
		if(WaitStrategyEnum.VISIBILITY.equals(waitStrategy))
		{
			element= new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(10))
					.until(ExpectedConditions.visibilityOfElementLocated(by));
		}
		else if(WaitStrategyEnum.PRESENCE.equals(waitStrategy)) 
		{
			element= new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(10))
					.until(ExpectedConditions.presenceOfElementLocated(by));
		}
		else if(WaitStrategyEnum.NONE.equals(waitStrategy)) 
		{
			element=DriverManager.getDriver().findElement(by);
		}
		return element;
	}
}
