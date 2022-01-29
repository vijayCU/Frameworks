package retryListeners;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

@Test(retryAnalyzer =RetryInterfaceImplement.class)//if want to retry all test methods
public class RetryDemo {

//@Test(retryAnalyzer =RetryInterfaceImplement.class) //for Retry only this method fails & want to retry	
	public void testA() 
	{
		Reporter.log("TEST A",true);
		Assert.fail();
	}
	
	@Test
	public void testB() 
	{
		Reporter.log("TEST B",true);
		Assert.fail();
	}
}
