package Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerMethodExecution implements ITestListener{
	
	  public void onStart(ITestContext context) {
		System.out.println("onStart:TestNG Starting");
	  }
		
	  public void onTestStart(ITestResult result) {
		System.out.println("onTestStart: Test Method Started");
      }

	  public void onFinish(ITestContext context) {
		System.out.println("onFinish: TestNG ending");
	  }
	
	  public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess: Test Method Execution Over : PASSED");
	  }
		
	  public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure:Test Method Execution Over : FAILED ");

	 }

	 public void onTestSkipped(ITestResult result) {
		System.out.println("onTestFailure:Test Method Not Executed  : SKIPPED ");
	  }

	  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	  }
		
}
