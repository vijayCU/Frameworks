package retryListener3;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

@Test(retryAnalyzer=RetryInterfaceImplement2.class)
public class RetryDemo2 {
	static boolean flag=true;
	public void testA() 
	{
		Reporter.log("TEST A",true);
	}
	
	public void testB() 
	{
		Reporter.log("TEST B",true);
		if(flag)
		{
			flag=false;
			Assert.fail();
		}
		
	}
}
