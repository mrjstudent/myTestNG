package testng.concepts;

import org.testng.annotations.Test;

public class ExpectedExceptions {

	@Test(expectedExceptions=NumberFormatException.class)
	public void exceptonHandling() {
		String a="100A";
		Integer.parseInt(a);
	}
	//the above test case will throw NumberFormatException and test case will be failed 
	//if we don't use "expectedExceptions=NumberFormatException.class"
}
