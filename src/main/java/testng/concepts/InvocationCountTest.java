package testng.concepts;

import org.testng.annotations.Test;

public class InvocationCountTest {
	@Test(invocationCount=10)
	public void sum() {
		int a=10;
		int b=15;
		int c=a+b;
		System.out.println("Total is ="+c);
	}
	//by using'invocationCount' keyword, a test case executes multiple times
}
