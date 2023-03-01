package testng.concepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest {
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

	@Test(priority=3, groups="search")
	public void search() {
		System.out.println("google search");
	}

	@Test(priority=1, groups="title")
	public void getTitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}
	@Test(priority=2, groups="logo")
	public void isLogoDisplayed() {
		boolean isLogoApeared=driver.findElement(By.xpath("//img[@class='lnXdpd']")).isDisplayed();
		System.out.println(isLogoApeared);
		
	}
	@Test(priority=-1, groups="search")
	public void sendSomeKey() {
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Afghanistan");
	}

	@AfterMethod
	public void quitBrowser() {
//		driver.quit();
	}
	//TestNG automatically creates html report. (after refresh)folder of 'test-output' automatically created 
	//right click on 'index.html' go to its property and copy the path and past to any browser
	//then you will see testNG html  report. Additionally, in report part 'emailable-report.html' is another 
	//type of testNG html report.
	
	//test cases with lower number get executed first(prioritized)
}
