package testngcheck;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo1 {
	
	@Test(invocationCount = 10)
	public void testA() throws InterruptedException {
		Reporter.log("Test A",true);
		Thread.sleep(500);
	}

	@Test(invocationCount = 10)
	public void testB() throws InterruptedException {
		Reporter.log("Test B",true);
		Thread.sleep(500);
	}
}
