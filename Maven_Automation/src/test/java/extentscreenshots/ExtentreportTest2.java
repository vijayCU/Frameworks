package extentscreenshots;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentreportTest2 {
	@Test
	public void report() throws IOException {
		DateFormat date = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
		String currentTime = date.format(new Date());

		ExtentReports eReports= new ExtentReports();
		ExtentSparkReporter spark= new ExtentSparkReporter("./target/Extent/Report.html");
		eReports.attachReporter(spark);
		ExtentTest test1= eReports.createTest("test1");
		test1.info("Set the path");
		WebDriverManager.chromedriver().setup();
		test1.info("Open the Browser");
		WebDriver driver= new ChromeDriver();
		test1.info("Enter the URL");
		driver.get("https://www.google.com");
		test1.info("Take the ScreenShot");
		TakesScreenshot t= (TakesScreenshot) driver;
		
		File srcFile = t.getScreenshotAs(OutputType.FILE);
		File destFile=new File("./target/image/login "+currentTime+".png");
		FileUtils.copyFile(srcFile, destFile);
		//Add Screenshots at TOP
		test1.addScreenCaptureFromPath("./../image/login "+currentTime+".png");
		//Add screenshot inline
		Media m = MediaEntityBuilder.createScreenCaptureFromPath("./../image/login "+currentTime+".png").build();
		test1.info("Details",m);
		test1.info("Close the Browser");
		driver.close();
		eReports.flush();
	}

}
