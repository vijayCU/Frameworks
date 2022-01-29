package HYBD_FW;

import java.lang.reflect.Method;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.Excel;

/*
 * ITestResult used to get result form testNG
 */
public class ExcelResultStatus {
	
	@BeforeMethod
	public void beforemethod(Method method ) {
		
		String testname = method.getName();
		Reporter.log("Method to be executed is :"+testname,true);
	}
	
	@Test
	public void login() {
		Reporter.log("login",true);
	}
	
	@Test
	public void logout() {
		Reporter.log("logout",true);
	}
	
	@AfterMethod
	public void aftermethod(ITestResult resultobj) {
		String tname = resultobj.getMethod().getMethodName();
		// status 1-pass, 2-Fail, not print Skip status as the test method is not executed
		int status = resultobj.getStatus();
		String msg="";
		if(status==1) {  msg="PASSED"; }
		if(status==2) {  msg="FAILED"; }
		
		Excel.setCellValue("./data/input.xlsx", "sheet4", 0, 0, tname);
		Excel.setCellValue("./data/input.xlsx", "sheet4", 0, 1, msg);
	}

}
