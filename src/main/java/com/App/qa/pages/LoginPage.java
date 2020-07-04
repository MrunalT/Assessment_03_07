package com.App.qa.pages;


import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.App.qa.testBase.Testbase;
import com.App.qa.utils.CommonFunctions;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;


public class LoginPage extends Testbase {
	
	
	CommonFunctions commonFunction;

	@FindBy(xpath = "//*[contains(text(), 'Sign up')]")
	WebElement btnSignup;
	
	@FindBy(xpath = "//*[@class='menu-nav']/li[5]/a")
	WebElement btnSignIn;
	
	@FindBy(className  = "Signin-style__center___YfGiy")
	WebElement btnSignup1;
	
	@FindBy(xpath = "//input[@type= 'text']")
	WebElement txtEmailID;
	
	@FindBy(xpath = "//input[@type= 'password']")
	WebElement txtPassword;
	
	
	@FindBy(className =   "Checkbox-style__check___e8GGP")
	WebElement chkBxTerms;
	
	@FindBy(name = "input")
	WebElement textFirstName;
	
	@FindBy(xpath = "//*[contains(text(), 'Create user profile')]")
	WebElement btnCreateProfile;
	
	
	public LoginPage() {
		
//		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 5);
		PageFactory.initElements(driver, this);
		commonFunction = new CommonFunctions();
		
	}
	
	
	//Application Login
	public void loginApp(String emailId ,String password ) throws Exception
	{
		commonFunction.click(btnSignIn, "Sign In Button");
		
		commonFunction.enterVal( txtEmailID,emailId, "Registered Email Address", false);
		
		commonFunction.enterVal( txtPassword,password, " Password", false);
		
		
		
		commonFunction.click(btnSignup1, "Sign In Button");
		
		String path = commonFunction.getScreenShot();
		if(btnCreateProfile.isDisplayed())
			reports.log(Status.PASS, "Logged in successfully", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		else
			reports.log(Status.PASS, "failed to log in which is as expected", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		
	}
	
	
	public void signUPApp(String emailId ,String password ) throws Exception
	{
		
		commonFunction.enterVal( txtEmailID,emailId, "Registered Email Address", false);
		
		commonFunction.enterVal( txtPassword,password, " Password", true);
		
		commonFunction.click(chkBxTerms, "Terms Checkbox");
		
		commonFunction.click(btnSignup, "Sign Up Button");
		

		
	}
	

}
