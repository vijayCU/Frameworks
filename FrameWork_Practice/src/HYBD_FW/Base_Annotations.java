package HYBD_FW;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Base_Annotations {

	 @BeforeSuite
	  public void beforeSuite() {
		 Reporter.log("BS",true);
	  }
	 @BeforeTest
	  public void beforeTest() {
		 Reporter.log("BT",true);
	  }
	 @BeforeClass
	  public void beforeClass() {
		 Reporter.log("BC",true);
	  }
	 @BeforeMethod
  	 public void beforeMethod() {
	  	Reporter.log("BM",true);
	 }
	 @AfterMethod
	 public void afterMethod() {
		 Reporter.log("AM",true);
	 }
	 @AfterClass
	 public void afterClass() {
	  Reporter.log("AC",true);
	 }
     @AfterTest
     public void afterTest() {
    	 Reporter.log("AT",true);
     }
     @AfterSuite
     public void afterSuite() {
	  Reporter.log("AS",true);
     }

}
