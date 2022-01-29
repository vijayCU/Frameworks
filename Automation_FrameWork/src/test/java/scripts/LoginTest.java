package scripts;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.TestListeners;
import pages.Loginpage;

@Listeners(TestListeners.class)
public class LoginTest extends BaseTest
{


	@Test(dataProvider = "getDataFromCSV")  // from XL to Data Provider --> getDataFromXL
	public void testLogin(String un,String pw)
	{
		Loginpage login=new Loginpage(driver, eTest, log4j);
		login.setUserName(un);
		login.setPassword(pw);
		login.clicklogin();
	}
}
