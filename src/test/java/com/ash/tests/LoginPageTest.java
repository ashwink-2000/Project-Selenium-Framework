package com.ash.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ash.PageObjects.HomePage;
import com.ash.PageObjects.LoginPage;
import com.ash.annotations.FrameworkAnnotation;
import com.ash.enums.CategoryType;
import com.ash.utilites.DataProviderUtility;

public class LoginPageTest extends BaseTest {

	@FrameworkAnnotation(author = {"Ashwin","TestAuthor"}, category = {CategoryType.REGRESSION,CategoryType.SMOKE})
	@Test(dataProvider ="loginpagedata",dataProviderClass=DataProviderUtility.class)
	void login(HashMap<String,String> data) throws InterruptedException 
	{
		LoginPage loginpage = new LoginPage();
		String title=loginpage.enterUserName(data.get("username")).enterPassword(data.get("password")).clickLogin()
				.clickProfile().logout().getTitle();
		Assert.assertEquals(title,"OrangeHRM");
	}

	@FrameworkAnnotation(author = {"Ashwin","TestAuthor"}, category = {CategoryType.REGRESSION,CategoryType.SMOKE})
	@Test(dataProvider="loginpagedata",dataProviderClass=DataProviderUtility.class)
	void login2(HashMap<String,String> data) throws InterruptedException  
	{
		LoginPage loginpage = new LoginPage();
		String title=loginpage.enterUserName(data.get("username")).enterPassword(data.get("password")).clickLogin()
				.clickProfile().logout().getTitle();
		Assert.assertEquals(title,"OrangeHRM");
	}
}
