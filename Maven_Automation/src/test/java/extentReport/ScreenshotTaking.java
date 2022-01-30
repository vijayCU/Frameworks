package extentReport;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotTaking {
	
	@Test
	public void screenshot() throws Exception 
	{
//		Date d= new Date();
//		String s1 = d.toString();
//		String s2 = s1.replace(":", "-");
		DateFormat date = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
		String currentTime = date.format(new Date());
		
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
		WebElement logo = driver.findElement(By.xpath("//div[@class='atLogoImg']"));
		File srcFile = logo.getScreenshotAs(OutputType.FILE);
		System.out.println(srcFile.getAbsolutePath());
		File destFile=new File("./target/Images/logo "+currentTime+".png");
		FileUtils.copyFile(srcFile, destFile);
		driver.close();
	}

}
