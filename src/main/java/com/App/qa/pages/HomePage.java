package com.App.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.App.qa.testBase.Testbase;
import com.App.qa.utils.CommonFunctions;

public class HomePage extends Testbase{
	CommonFunctions commonFunction;
	@FindBy(xpath = "//*[contains(text(), 'Sign up')]")
	WebElement btnSignup;
	
	

	public HomePage()
	{
		PageFactory.initElements(driver, this);
		commonFunction = new CommonFunctions();
	}
	
	public void validateHomePageTitle()
	{
		Assert.assertEquals("Time tracking software for productive teams", driver.getTitle(),"Failed to Open");
	}

	
	public LoginPage clickSignUpButton() throws Exception
	{
		commonFunction.click(btnSignup, "Sign Up Button");
		return new LoginPage();
		
	}
	
	
	
	
	
}
