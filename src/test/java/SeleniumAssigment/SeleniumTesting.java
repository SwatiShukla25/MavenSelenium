package SeleniumAssigment;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTesting {
	WebDriver driver;
	String[] radiobtn = {"Round Trip","One Way"};
	@BeforeClass
	public void setUp()
	{
		//System.setProperty("webdriver.chrome.driver", "src/test/java/Resourses/chromedriver.exe");
	WebDriverManager.chromedriver().setup();
	
		driver = new ChromeDriver();
		
		driver.get("https://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		
	}
	@Test(priority =1)
	public void A_User_Login() {
		WebElement username=driver.findElement(By.name("userName"));
		username.sendKeys("test");
		WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
		password.sendKeys("test");
		WebElement submitbtn= driver.findElement(By.cssSelector("input[name='submit']"));
		submitbtn.click();
	}
		@Test(priority=2)
		public void book_a_flight() {
			
			String oneway ="One Way";
		String	radiobtn1="One Way";
			
			
			WebElement flightbooking= driver.findElement(By.xpath("//a[contains(text(),'Flights')]"));
			flightbooking.click();
			List<WebElement> oneWayRadioBtn=driver.findElements(By.xpath("//tbody/tr[2]/td[2]/b[1]/font[1]/input[2]"));
			for (int i=0;i<oneWayRadioBtn.size(); i++)

			{
				oneWayRadioBtn.get(i).getText();
			    List radiobtn = Arrays.asList(radiobtn1);
			    		if (radiobtn.contains(oneway))
				{
			
					//driver.findElements(By.xpath("//tbody/tr[2]/td[2]/b[1]/font[1]/input[2]")).get(i).click();
					oneWayRadioBtn.get(i).click();

				}
						}
			WebElement passengerDropDown=driver.findElement(By.xpath("//tbody/tr[3]/td[2]/b[1]/select"));
			Select dropdown = new Select(passengerDropDown);
		    dropdown.selectByIndex(1);
		    
		    WebElement DepartingDropdown = driver.findElement(By.xpath("//tbody/tr[4]/td[2]/select"));
		    Select dropdown1 = new Select (DepartingDropdown);
		    dropdown1.selectByValue("Paris");
		    
		    
		    WebElement MonthDropDown = driver.findElement(By.xpath("//tbody/tr[5]/td[2]/select[1]"));
		    Select dropdown2 = new Select(MonthDropDown);
		    dropdown2.selectByIndex(8);
		    
		    WebElement dateDropDown = driver.findElement(By.xpath("//tbody/tr[5]/td[2]/select[2]"));
		    Select dropdown3 = new Select(dateDropDown);
		    dropdown3.selectByValue("21");
		    
		    WebElement ArrivingDropdown = driver.findElement(By.xpath("//tbody/tr[6]/td[2]/select"));
		    Select dropdown4 = new Select (ArrivingDropdown);
		    dropdown4.selectByValue("Seattle");
		    
		    WebElement ReturnMonthDropDown = driver.findElement(By.xpath("//tbody/tr[7]/td[2]/select[1]"));
		    Select dropdown5 = new Select(ReturnMonthDropDown);
		    dropdown5.selectByIndex(10);
		    
		    WebElement ReturndateDropDown = driver.findElement(By.xpath("//tbody/tr[7]/td[2]/select[2]"));
		    Select dropdown6 = new Select(ReturndateDropDown);
		    dropdown6.selectByValue("21");   
		    
		    WebElement submitbtn = driver.findElement(By.xpath("//input[@name='findFlights']"));
		    submitbtn.click();
 		
			
		}
		
		@AfterClass
		public void tearDown()
		{
			driver.close();
			driver.quit();
		}
}
	
