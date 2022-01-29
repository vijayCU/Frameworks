package testngcheck;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo2 {
	
	@Test(invocationCount = 10)
	public void testC() throws InterruptedException {
		Reporter.log("Test C",true);
		Thread.sleep(500);
	}

	@Test(invocationCount = 10)
	public void testD() throws InterruptedException {
		Reporter.log("Test D",true);
		Thread.sleep(500);
	}
}
