package retryListeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryInterfaceImplement implements IRetryAnalyzer {

	public boolean retry(ITestResult result) {
		System.out.println("Retry Test");
		return false;
	}
}
