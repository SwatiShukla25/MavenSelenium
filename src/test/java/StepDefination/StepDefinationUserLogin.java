package StepDefination;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinationUserLogin {
	
	WebDriver driver;
	@Given("^Launched NewTours Demo login page$")
	public void Launched_NewTours_Demo_login_page() {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		System.out.println("Inside Step- user is on login page");
	}

	@When("^User enters valid User Name and Password$")
	public void User_enters_valid_User_Name_and_Password() {
		WebElement username=driver.findElement(By.name("userName"));
		username.sendKeys("test");
		WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
		password.sendKeys("test");		
	}

	@And("^User clicked on Submit button$")
	public void User_clicked_on_Submit_button() {
		WebElement submitbtn= driver.findElement(By.cssSelector("input[name='submit']"));
		submitbtn.click();
		
		System.out.println("Inside Steps- clicks on login button");
	}

	@Then("^User successfully logged in to the home page$")
	public void User_successfully_logged_in_to_the_home_page() {
		System.out.println("user is navigated to the home page");
		String title=driver.getTitle();
		Assert.assertEquals(title, "Login: Mercury Tours");
	}
}