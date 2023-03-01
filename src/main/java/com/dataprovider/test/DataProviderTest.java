package com.dataprovider.test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderTest {
	
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://tek-insurance.azurewebsites.net/");
	}
	@DataProvider
	public void getTestData() throws IOException {
		ReadFromExcelFile.getDataFromExcel("Sheet1");	
	}
	@Test(dataProvider="getTestData")
	public void createAccountPage(String username, String password,String emailAddress
			,String firstName, String lastName, String employmentStatus) {
		driver.findElement(By.xpath("//input[@formcontrolname='username']"))
		.sendKeys("supervisor");
		driver.findElement(By.xpath("//input[@formcontrolname='password']"))
		.sendKeys("tek_supervisor");
		driver.findElement(By.xpath("//span[contains(text(),'Login')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Accounts')]")).click();
		driver.findElement(By.xpath("//span[contains(text(), 'Add new account')] ")).click();
		driver.findElement(By.id("email")).sendKeys("emailAddress");
		driver.findElement(By.name("title")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Mr.')]")).click();
		driver.findElement(By.id("firstName")).sendKeys("firstName");
		driver.findElement(By.name("lastName")).sendKeys("lastName");
		driver.findElement(By.name("gender")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Male')]")).click();
		driver.findElement(By.xpath("//mat-select[@name='maritalStatus']")).click();
		driver.findElement(By.xpath("//mat-option[@value='SINGLE']//span")).click();
		driver.findElement(By.name("employmentStatus")).sendKeys("employmentStatus");
		driver.findElement(By.xpath("//button[@type='submit']//span[1]")).click();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
