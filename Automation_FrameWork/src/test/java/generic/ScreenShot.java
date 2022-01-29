package generic;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ScreenShot 
{
	public ExtentTest eTest;
	public Logger log4j;
	
	public ScreenShot(ExtentTest eTest,Logger log4j)

	{
			this.eTest=eTest;
			this.log4j=log4j;
	}
	
	public static void getScreenShot(WebElement element, String path) //Take SS of Element
	{
		File srcFile = element.getScreenshotAs(OutputType.FILE);
		try 
		{
			FileUtils.copyFile(srcFile,new File(path+".png"));
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void getScreenShot(WebDriver driver, String path)// Take SS of Browser
	{
		TakesScreenshot t=(TakesScreenshot) driver;
		File srcFile = t.getScreenshotAs(OutputType.FILE);
		try 
		{
			FileUtils.copyFile(srcFile,new File(path+".png"));
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void getScreenshot(String path) // take SS of Desktop
	{
		try {
		Robot robot=new Robot();
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle screenshot=new Rectangle(screensize);
		BufferedImage img = robot.createScreenCapture(screenshot);
		ImageIO.write(img, "PNG", new File(path+".png"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	
	public static void getScreenshot(WebDriver driver,String path,int scrollDelay)// Scroll full page & take SS
	{
		try
		{
			AShot ashot= new AShot();
			Screenshot image = ashot.shootingStrategy(ShootingStrategies.viewportPasting(scrollDelay)).takeScreenshot(driver);
			ImageIO.write(image.getImage(),"png",new File(path+".png"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
