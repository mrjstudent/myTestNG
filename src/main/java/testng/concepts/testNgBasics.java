package testng.concepts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testNgBasics {
	//sequence of execution is: BeforeSuite,BeforeTest,BeforeClass,BeforeMethod,Test
	//except @BeforeMethod and @AfterMethode, rest of annotations are one time time execution
	//but these two annotations are executed with each @Test.
		@BeforeSuite 
		public void setUp() {
			System.out.println("before suite methode");
		}
		@BeforeClass
		public void launchBrowser() {
			System.out.println("before class method");
		}
		@BeforeMethod
		public void enterURL() {
			System.out.println("before methode ");

		}
		@BeforeTest
		public void login() {
			System.out.println("before test method");
		}
		@Test
		public void googleTitleTest() {
			System.out.println("this is the case it self");
		}
		@Test
		public void searchTest() {
			System.out.println("search test method");
		}
		@AfterMethod
		public void logout() {
			System.out.println("after method");
		}
		@AfterTest
		public void deleteAllCookies() {
			System.out.println("After test");
		}
		@AfterClass
		public void closeBrowser() {
			System.out.println("After class method");
		}
		@AfterSuite
		public void generateReport() {
			System.out.println("after Suite method");
		}

}
