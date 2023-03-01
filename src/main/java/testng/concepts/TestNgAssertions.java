package testng.concepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNgAssertions {

	WebDriver driver;

	@BeforeMethod

	public void setUp() {
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.google.com/");

	}
		@Test
		public void getTitle() {
		String title = driver.getTitle();
		System.out.println(title);
	  //Assert.assertEquals(title, "Google");//this will pass
		Assert.assertEquals(title, "Google123");

	}
		@Test
		public void isLogoDisplayed() {
		boolean isLogoApeared=driver.findElement(By.xpath("//img[@class='lnXdpd']")).isDisplayed();
		System.out.println(isLogoApeared);
		Assert.assertTrue(isLogoApeared); //or we can validate like below
	  //Assert.assertEquals(isLogoApeared, true);
			
		}
		@AfterMethod
		public void quitBrowser() {
			driver.quit();
		}

}
