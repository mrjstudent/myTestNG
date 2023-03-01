package testng.concepts;

import org.testng.annotations.Test;

public class dependsOnMethods {
 
	@Test
	public void loginTest() {
		System.out.println("login test method");
		int number=9/0;
	}
	@Test(dependsOnMethods="loginTest")
	public void HomepageTest() {
		System.out.println("home page test method");
	}
	@Test
	public void searchPageTest() {
		System.out.println("search page test method");
	}
	//'dependsOnMethods' is a testNG feature, if the first test case failed the second test
	//case will be skipped and skipped case is marked with yellow color in report part.
}
