package com.App.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.App.qa.pages.GmailLogin;
import com.App.qa.pages.HomePage;
import com.App.qa.pages.LoginPage;
import com.App.qa.testBase.Testbase;
import com.App.qa.utils.CommonFunctions;

public class SignUpApplication extends Testbase {

	
	LoginPage loginPage;
	HomePage homePage;
	GmailLogin gmailLogin;
	
	private String sTestCaseName;
	
	
	SignUpApplication(){
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
	public void SignUpApp() throws Exception
	{
		homePage.validateHomePageTitle();
		loginPage = homePage.clickSignUpButton();
		loginPage.signUPApp(prop.getProperty("username"), "Test@523");
		gmailLogin = new GmailLogin();
		gmailLogin.clickActivationLink(prop.getProperty("username"), "#####");
		
		
	}
	
	@AfterMethod
	public void logout()
	{
		close();
	}
}
