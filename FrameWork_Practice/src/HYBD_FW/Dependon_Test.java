package HYBD_FW;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;


public class Dependon_Test {
	
	@Test(priority = 1)
	public void openapp() {
		Reporter.log("Open App",true);
	}
	
	@Test(priority = 2)
	public void login() {
		Reporter.log("Login to App",true);
		Assert.fail();
	}
	
	@Test(dependsOnMethods = {"openapp","login"})
	public void logout() {
		Reporter.log("Logout from App",true);
	}

}
