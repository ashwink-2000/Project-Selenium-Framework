package com.ash.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ash.PageObjects.HomePage;
import com.ash.PageObjects.LoginPage;
import com.ash.utilites.DataProviderUtility;

public class LoginPageTest extends BaseTest {

	@Test(dataProvider ="loginpagedata",dataProviderClass=DataProviderUtility.class)
	void login(HashMap<String,String> data) throws InterruptedException 
	{
		LoginPage loginpage = new LoginPage();
		HomePage homePage=loginpage.enterUserName(data.get("username")).enterPassword(data.get("password")).clickLogin();
		Thread.sleep(3000);
	}

	@Test(dataProvider="loginpagedata",dataProviderClass=DataProviderUtility.class)
	void login2(HashMap<String,String> data) throws InterruptedException 
	{
		LoginPage loginpage = new LoginPage();
		HomePage homePage=loginpage.enterUserName(data.get("username")).enterPassword(data.get("password")).clickLogin();
		Assert.assertEquals(false, true);
		Thread.sleep(3000);
	}
}
