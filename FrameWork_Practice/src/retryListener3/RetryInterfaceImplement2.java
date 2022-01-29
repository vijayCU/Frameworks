package retryListener3;

import java.util.ArrayList;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryInterfaceImplement2 implements IRetryAnalyzer {

	ArrayList<String> testlist= new ArrayList<String>();
	public boolean retry(ITestResult result) {
		String testname= result.getMethod().getMethodName();
		if(testlist.contains(testname)) {
			return false;
		}
		else {
		testlist.add(testname);
		return true;
		}
	}
}