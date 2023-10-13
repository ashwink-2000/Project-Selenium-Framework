package com.ash.project;

import org.testng.annotations.Test;

import com.ash.PageObjects.HomePage;
import com.ash.PageObjects.LoginPage;

public class LoginPageTest extends BaseTest {

	@Test
	void Test1() throws InterruptedException 
	{
		LoginPage loginpage = new LoginPage();
		HomePage homePage=loginpage.enterUserName("Admin").enterPassword("admin123").clickLogin();
		Thread.sleep(3000);
	}
	
	@Test
	void Test2() throws InterruptedException 
	{
		LoginPage loginpage = new LoginPage();
		HomePage homePage=loginpage.enterUserName("Admin").enterPassword("admin123").clickLogin();
		Thread.sleep(3000);
	}
}
