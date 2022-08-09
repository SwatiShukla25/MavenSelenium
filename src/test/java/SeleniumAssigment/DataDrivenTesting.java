package SeleniumAssigment;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDrivenTesting {
	
	WebDriver driver;
	// To get data from dataprovider
		@Test(dataProvider="testdataset")
		public void fbLoginLogout(String email, String password) throws Exception{
			
			// Initalizing webdriver
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\java\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();		
			// To maxamize the browser window
			driver.manage().window().maximize();
			// Implicit wait of 20 seconds
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			// To launch facebook
			driver.get("https://demo.guru99.com/test/newtours/");
			WebElement username=driver.findElement(By.name("userName"));
			username.sendKeys("user");
			WebElement password1 = driver.findElement(By.xpath("//input[@type='password']"));
			password1.sendKeys("pwd");
			WebElement submitbtn= driver.findElement(By.cssSelector("input[name='submit']"));
			submitbtn.click();
			/* To clear the email field
			driver.findElement(By.xpath("//input[@type='email'][@name='email']")).clear();
			// To pass Email
			driver.findElement(By.xpath("//input[@type='email'][@name='email']")).sendKeys(email);
			// To clear password field
			driver.findElement(By.xpath("//input[@type='password'][@name='pass']")).clear();	
			// To pass password
			driver.findElement(By.xpath("//input[@type='password'][@name='pass']")).sendKeys(password);
			// To click on Login button
			driver.findElement(By.xpath("//input[@type='submit'][@id='u_0_5']")).click();
			// To click on Account settings dropdown		
			driver.findElement(By.xpath("//div[text()='Account Settings']")).click();
			// To click on logout button
			driver.findElement(By.xpath("//text()[.='Log Out']/ancestor::span[1]")).click();*/
				
		}
		// @DataProvider passes data to test cases. Here I took 2 dimension array. 
		@DataProvider(name="testdataset")
		public Object[][] getData(){
			// Create object with two paraments
			// first parameter is row and second one is column
			Object[][] data = new Object[2][2];
			data[0][0] = "testemailone@gmail.com";
			data[0][1] = "password";
			
			data[1][0] = "testemailtwo@test.com";
			data[1][1] = "password";

			return data;
		}
	}

