package com.ash.PageObjects;

import org.openqa.selenium.By;

import com.ash.enums.WaitStrategyEnum;

public class HomePage extends BasePage {
	private final By buttonProfile = By.xpath("//span[@class='oxd-userdropdown-tab']");
	private final By buttonLogout = By.xpath("//a[text()='Logout']");
	
	
	public HomePage clickProfile() {
		clickElement(buttonProfile,"ProfileButton",WaitStrategyEnum.VISIBILITY);
		return this;
	}
	
	public LoginPage clickLogout() {
		clickElement(buttonLogout,"Logout button",WaitStrategyEnum.VISIBILITY);
		return new LoginPage();
	}
}
