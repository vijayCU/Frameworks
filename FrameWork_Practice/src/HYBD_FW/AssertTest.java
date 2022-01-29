package HYBD_FW;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertTest {
	/*
	 *  Assert 						 Soft Assert
	 * All methods are static				Softassert methods are nonstatic
	 * use class name						use object/ref variable
	 * compare & report 					only compare, for report use assertEquals
	 * Hard Assert							Verify
	 * will not execute remaining code 		will not execute remaining code 
	 * of current test iteraion.			of current test iteraion.
	 * 
	 */
	@Test(invocationCount = 2)
	public void asserttest() {
		Reporter.log("open App",true);
		Reporter.log("login",true);
		Reporter.log("varify",true);
		String actual="abcd";
		String expected="abcd";
		SoftAssert s= new SoftAssert();
		s.assertEquals(actual, expected);// only compare
//		Assert.assertEquals(actual, expected);
		s.assertAll();//report PASS/FAIL
		Reporter.log("logout",true);
		Reporter.log("close App",true);
	}

}