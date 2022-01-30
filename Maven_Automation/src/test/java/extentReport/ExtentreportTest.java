package extentReport;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentreportTest {
	@Test
	public void report() {
		// Create object of ExtentReports
		ExtentReports eReports= new ExtentReports();
		
		//Create object of format -spark/avent/email and attach it to ExtentReport
		ExtentSparkReporter spark= new ExtentSparkReporter("./target/ExtentReport.html");
		eReports.attachReporter(spark);
		
		//create test object and report the message
		ExtentTest test1= eReports.createTest("test1");
		test1.log(Status.INFO, "Hi");
		test1.log(Status.PASS, "Hi");
		test1.log(Status.FAIL, "Hi");
		test1.log(Status.SKIP, "Hi");
		
		ExtentTest test2= eReports.createTest("test2");
		test2.info("Hi");
		test2.pass("Hi");
		test2.fail("Hi");
		test2.skip("Hi");
		
		//publish Report
		eReports.flush();
	}

}
