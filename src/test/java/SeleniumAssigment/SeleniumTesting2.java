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
import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class SeleniumTesting2 {

	WebDriver driver;

	@BeforeClass
	public void loginscreen() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.satisfice.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@Test
	public void menuBarOptions() {

		List<WebElement> MainMenuItems = driver.findElements(By.xpath("//ul[@id='menu-main-navigation']/li"));
		System.out.println(MainMenuItems.size());

		for (int i = 1; i <= MainMenuItems.size(); i++) {

			WebElement links = driver.findElement(By.xpath("//ul[@id='menu-main-navigation']/li[" + i + "]/a"));
			System.out.println(links.getText());

			Actions action = new Actions(driver);

			action.moveToElement(links).build().perform();

			List<WebElement> SubMenu = links
					.findElements(By.xpath("//ul[@id='menu-main-navigation']/li[" + i + "]/ul[@class='sub-menu']/li"));

			System.out.println(SubMenu.size());
			for (int j = 1; j <= SubMenu.size(); j++) {

				WebElement sub = driver.findElement(By
						.xpath("//ul[@id='menu-main-navigation']/li[" + i + "]/ul[@class='sub-menu']/li[" + j + "]/a"));

				System.out.println(sub.getText());
				action.moveToElement(sub).build().perform();

			}
		}
	}

	@Test
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
