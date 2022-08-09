package SeleniumAssigment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonLogin {
	WebDriver driver;

	@BeforeClass
	public void SetUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

	}

	@Test(priority = 1)
	public void LoginToApp() {

		WebElement sign = driver.findElement(By.xpath("//div/span[contains(text(),'Hello, Sign in')]"));
		Actions action = new Actions(driver);
		action.moveToElement(sign).build().perform();
		WebElement SignInbtn = driver.findElement(By.xpath("//a[@class='nav-action-button']"));
		SignInbtn.click();
		WebElement emailtxtbox = driver.findElement(By.cssSelector("#ap_email"));
		emailtxtbox.sendKeys("swatishukla25@yahoo.com");
		WebElement submitbtn = driver.findElement(By.xpath("//input[@id='continue']"));
		submitbtn.click();

		WebElement password = driver.findElement(By.id("ap_password"));
		password.sendKeys("April277");

		WebElement signinbtn = driver.findElement(By.id("signInSubmit"));
		signinbtn.click();
	}

	@Test(priority = 2)
	public void AddProduct() {

		WebElement serachproduct = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
		Actions act = new Actions(driver);
		act.moveToElement(serachproduct).build().perform();
		serachproduct.sendKeys("apple airpods pro ");

		WebElement searchbtn = driver.findElement(By.cssSelector("#nav-search-submit-button"));
		searchbtn.click();

		WebElement selectProduct=driver.findElement(By.xpath("//div/h2/a/span[contains(text(),'Apple AirPods Pro Wireless')]"));
		selectProduct.click();
		
		WebElement addToCart = driver.findElement(By.id("add-to-cart-button"));
		addToCart.click();
		
		
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}
	

}
