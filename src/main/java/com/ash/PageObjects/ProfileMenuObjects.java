package com.ash.PageObjects;

import org.openqa.selenium.By;

import com.ash.enums.WaitStrategyEnum;
import com.ash.utilites.DynamicLocatorUtility;

public final class ProfileMenuObjects extends BasePage{
	
	private String menuOptions="//a[@role='menuitem' and text()='%s']";
	//a[@role='menuitem' and text()='Logout']
	
	public LoginPage logout()
	{
		By logout=By.xpath(DynamicLocatorUtility.getXpath(menuOptions,"Logout"));
		clickElement(logout,"Logout button",WaitStrategyEnum.CLICKABLE);

		return new LoginPage();
	}
}
