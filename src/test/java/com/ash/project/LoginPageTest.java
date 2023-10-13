package com.ash.project;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.ash.driver.DriverManager;

public class LoginPageTest extends BaseTest {

	@Test
	void Test1() throws InterruptedException
	{
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("automation",Keys.ENTER);
		Thread.sleep(3000);
	}
	
	@Test
	void Test2() throws InterruptedException
	{
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("tcs",Keys.ENTER);
		Thread.sleep(3000);
	}
}
