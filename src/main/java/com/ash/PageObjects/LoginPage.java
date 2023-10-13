package com.ash.PageObjects;

import org.openqa.selenium.By;

import com.ash.enums.WaitStrategyEnum;

public final class LoginPage extends BasePage {

	private final By textboxUsername = By.name("username");
	private final By textboxPassword = By.name("password");
	private final By buttonLogin = By.xpath("//button[@type='submit']");
	
	public LoginPage enterUserName(String userName)
	{
		EnterText(textboxUsername,userName,WaitStrategyEnum.PRESENCE);
		return this;
	}
	
	public LoginPage enterPassword(String password)
	{
		EnterText(textboxPassword,password,WaitStrategyEnum.PRESENCE);
		return this;
	}
	
	public HomePage clickLogin()
	{
		clickElement(buttonLogin,"button_login",WaitStrategyEnum.VISIBILITY);
		return new HomePage();
	}
}
