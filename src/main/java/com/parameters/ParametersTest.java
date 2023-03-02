package com.parameters;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParametersTest {

	WebDriver driver;

	@Test
	@Parameters({ "url", "username", "password" })
	public void yahooLoginTest(String url, String username, String password)
			throws InterruptedException {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.manage().window().maximize();
		driver.get(url);
//		driver.findElement(By.linkText("Sign in")).click();
//		driver.findElement(By.id("login-username")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("login-username")).sendKeys(username);
		driver.findElement(By.id("login-signin")).click();
//		driver.findElement(By.id("login-passwd")).clear();
		driver.findElement(By.id("login-passwd")).sendKeys(password);
		driver.findElement(By.id("login-signin")).click();
		
		System.out.println("this is just for pulling practice of git")
	}

}
