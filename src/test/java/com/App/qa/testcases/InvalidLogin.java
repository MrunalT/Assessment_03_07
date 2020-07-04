package com.App.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.App.qa.pages.GmailLogin;
import com.App.qa.pages.HomePage;
import com.App.qa.pages.LoginPage;
import com.App.qa.testBase.Testbase;
import com.App.qa.utils.CommonFunctions;

public class InvalidLogin extends Testbase{

	
	LoginPage loginPage;
	HomePage homePage;
	GmailLogin gmailLogin;
	
	private String sTestCaseName;
	
	
	InvalidLogin(){
		try {
			sTestCaseName = CommonFunctions.getTestCaseName(this.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@BeforeMethod
	public void setUp() throws Exception
	{
		
			initialization();
			reportSetting(sTestCaseName);
			homePage = new HomePage();
	}
	
	@Test
	public void invalidLogin() throws Exception
	{
		homePage.validateHomePageTitle();
		loginPage = new LoginPage();
		loginPage.loginApp(prop.getProperty("username"), "test@123");
		
	}
	
	@AfterMethod
	public void logout()
	{
		close();
	}
}
