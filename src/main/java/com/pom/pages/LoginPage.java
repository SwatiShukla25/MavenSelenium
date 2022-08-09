package com.pom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pom.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory
	@FindBy(name="userName")
	WebElement username;

	@FindBy(xpath = "//input[@type='password']")
	WebElement password;
	
	@FindBy (css = "input[name='submit']")
	WebElement submitbtn;
	
	@FindBy(xpath = "//img[contains (@role ,'presentation')]")
	WebElement guru99Logo;
	
	public LoginPage() {
		PageFactory.initElements(driver,this);
	}
	public String ValidateLoginPagetitle()
	{
		return driver.getTitle();
	}
	
	public boolean ValidateImage()
	{
		return guru99Logo.isDisplayed();	}
	
	public void login(String un,String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		submitbtn.click();
	}
}
