package listeners2;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ListenerDemo1 {

	@BeforeMethod
	public void bm() {
		Reporter.log("BeforeMethod",true);
	}
		
	@Test
	public void testA()
	{
		Reporter.log("Test A",true);
	}
	
	@Test
	public void testB()
	{
		Reporter.log("Test B",true);
		Assert.fail();
	}
	
	@Test(dependsOnMethods = "testB")
	public void testC()
	{
		Reporter.log("Test C",true);
	}
	
	@AfterMethod
	public void am() {
		Reporter.log("AfterMethod",true);
	}
}
