package com.pom.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pom.base.TestBase;
import com.pom.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginpage;
	String login_sucess;
	
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeClass
	public void setUp()
	{
		initialization();
		loginpage	= new LoginPage();
		
	}
	
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		
		String title = loginpage.ValidateLoginPagetitle();
		Assert.assertEquals(title, "Welcome: Mercury Tours");
	
	}
	
	@Test (priority=2)
	public void Guru99LogoImageTest()
	{
		boolean flag = loginpage.ValidateImage();
		Assert.assertTrue(flag);
	}
	@Test (priority=3)
	public void loginTest()
	{
		loginpage.login(prop.getProperty("userName"), prop.getProperty("password"));
		//return new login_sucess;
	}
	@AfterClass
	public void tearDown()
	{
		driver.quit();
		
	}

}
