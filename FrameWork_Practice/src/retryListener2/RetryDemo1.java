package retryListener2;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

@Test(retryAnalyzer=RetryInterfaceImplement1.class)
public class RetryDemo1 {

	public void testA() 
	{
		Reporter.log("TEST A",true);
		Assert.fail();
	}
	
//	public void testB() 
//	{
//		Reporter.log("TEST B",true);
//		Assert.fail();
//	}
}
