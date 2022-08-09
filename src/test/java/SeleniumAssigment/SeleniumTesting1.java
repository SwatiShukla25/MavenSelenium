package SeleniumAssigment;

import java.time.Duration;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTesting1 {

	WebDriver driver;
	
	@BeforeClass
	public void loginscreen()
	{
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
}
	@Test
	public void menuBarOptions() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@class='_2AkmmA _29YdH8']")).click();

	    String searchSubMenu = "Electronics";

	    int totalSubMenu = driver.findElements(By.xpath("//*[contains(@class,'Wbt_B2')]")).size();

	    System.out.println("Search for : " +searchSubMenu);

	    for(int i=1; i<=totalSubMenu; i++) {
	        String getTextSubMenu = driver.findElement(By.xpath("(//*[contains(@class,'Wbt_B2')])[" +i +"]")).getText();
	        System.out.println("Get Sub Menu Title : "+ getTextSubMenu);
	        if (getTextSubMenu.equals(searchSubMenu)) {
	            driver.findElement(By.xpath("(//*[contains(@class,'Wbt_B2')])[" +i +"]")).click();
	            Thread.sleep(1000);
	            String targetAllGetText = driver.findElement(By.xpath("(//*[contains(@class,'_3GtRpC')])[" +i +"]")).getText();
	            System.out.println(targetAllGetText);
	            break;

	
}
}
	}
}
	
	

