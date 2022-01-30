package extentReport;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotTakingDesktop {
	
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
		Thread.sleep(1000);
		
		Robot robot=new Robot();
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
//		Rectangle screenshot=new Rectangle(20,20,1366,768);// Hardcoded values
		Rectangle screenshot=new Rectangle(screensize);
		BufferedImage img = robot.createScreenCapture(screenshot);
		ImageIO.write(img,"jpg", new File("./target/Images/desktop "+currentTime+".jpg"));
//		
		driver.close();
	}

}
