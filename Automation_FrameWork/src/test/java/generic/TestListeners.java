package generic;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;

public class TestListeners implements ITestListener
{

	public void onTestStart(ITestResult result) {
		
	}

	public void onTestSuccess(ITestResult result) {
		
	}

	public void onTestFailure(ITestResult result) {
		String timestamp=FileUtils.currentDateTime();
		String screenshotpath = Iconstants.IMAGEPATH+timestamp;
//		ScreenShot.getScreenshot(screenshotpath); //Desktop Screenshot
		//Browser Screenshot
		Object testobj = result.getInstance(); //get current test class object
		BaseTest base=(BaseTest) testobj; //downcasting Object to BaseTest
		WebDriver driver=base.driver; // Get current driver
		ExtentTest etest = base.eTest; //Get current extent Report
		ScreenShot.getScreenShot(driver, screenshotpath); //get page Screenshot
		Media media = MediaEntityBuilder.createScreenCaptureFromPath("./../images/"+timestamp+".png").build();
		etest.fail(media);
//		 adding Screenshot at top
		etest.addScreenCaptureFromPath("./../images/"+timestamp+".png");
		

		
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
	}
	

}
