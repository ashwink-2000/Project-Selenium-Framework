package com.ash.PageObjects;

import org.openqa.selenium.By;

import com.ash.enums.WaitStrategyEnum;

public class HomePage extends BasePage {
	private final By buttonProfile = By.xpath("//span[@class='oxd-userdropdown-tab']");
	
	
	public ProfileMenuObjects clickProfile() {
		clickElement(buttonProfile,"ProfileButton",WaitStrategyEnum.VISIBILITY);
		return new ProfileMenuObjects();
	}
}
