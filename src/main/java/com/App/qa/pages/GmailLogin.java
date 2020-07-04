package com.App.qa.pages;


import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.App.qa.testBase.Testbase;
import com.App.qa.utils.CommonFunctions;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import org.openqa.selenium.JavascriptExecutor;
public class GmailLogin extends Testbase {

	
	CommonFunctions commonFunction;
	
	@FindBy(xpath = "//*[contains(text(), 'Sign in')]")
	WebElement btnSignin;
	
	
	@FindBy(xpath = "//input[@name= 'username']")
	WebElement txtUserName;
	
	@FindBy(xpath = "//*[@value = 'Next']")
	WebElement BtnUserNext;
	
	
	@FindBy(xpath = "//*[@name = 'verifyPassword']")
	WebElement BtnPassNext1;
	
	
	
	@FindBy(id = "login-passwd")
	WebElement BtnPassword;
	
	
	@FindBy(xpath = "//span[@title = 'Activate your Timesheets account']")
	WebElement mail;
	
	@FindBy(xpath = "//*[contains(@href , 'https://auth.quidlo.com/signin?action=activate')]")
	WebElement btnActivateAcc;
	
	@FindBy(xpath = "//input[@type= 'text']")
	WebElement txtEmailID;
	

	
	
	public GmailLogin()
	{
		PageFactory.initElements(driver, this);
		commonFunction = new CommonFunctions();
	}
	
	
	public void clickActivationLink(String username, String password ) throws Exception
	{
		driver.get("https://mail.yahoo.com/");
		
		commonFunction.click(btnSignin, "Sign in button");
		
		
		commonFunction.enterVal( txtUserName,username, "Registered Email Address", false);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", BtnUserNext);
//		commonFunction.click(BtnUserNext, "Next Button");
		
		commonFunction.enterVal( BtnPassword,password, " Password", true);
		
		js.executeScript("arguments[0].click();", BtnUserNext);
		js.executeScript("arguments[0].click();", mail);
		js.executeScript("arguments[0].click();", mail);
		
		
		commonFunction.click(btnActivateAcc, "Activate Link Button");
		
		String parentWin = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles(); 
		
		
		for(String s : windows)
		{
			if(!parentWin.contains(s))
			driver.switchTo().window(s);
			
		}
	
		Assert.assertEquals("Timesheets", driver.getTitle(),"Failed to Activate");
		String path = commonFunction.getScreenShot();
		reports.log(Status.PASS, "Account is activated successfully.", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
	}
}
