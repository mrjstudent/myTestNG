package dataprovider.hardcode;

import java.time.Duration;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDrivenTest {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.manage().window().maximize();
		
		
	}

	@Test(dataProvider="getData")
	public void loginTest(String email, String password) {
		driver.get("https://mail.yahoo.com/");
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("login-username")).sendKeys(email);
		driver.findElement(By.id("login-signin")).click();
//		driver.findElement(By.id("login-passwd")).clear();
		driver.findElement(By.id("login-passwd")).sendKeys(password);
		driver.findElement(By.id("login-signin")).click();
	}
	@DataProvider(name="getData")
	public String[][] getData() {
		String[][] loginData = { 
				{ "jamalyreza90@yahoo.com", "MRJmrj!22" },
				{ "jamalyreza90@yahoo.com", "******" }};
				
		// to use multiple data type we can use 'Object' instead of 'String'
		
		return loginData;

	}
	@AfterMethod
	public void tearDown() {

//		driver.quit();
	}

}
