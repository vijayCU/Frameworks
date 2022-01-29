package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import generic.DBUtils;
import generic.FileUtils;
import generic.JSUtils;
import generic.RobotUtils;
import generic.ScreenShot;
import generic.WebUtils;

public class BasePage 
{
	public WebDriver driver;
	public ExtentTest eTest;
	public static ExtentReports extentReports;
	public Logger log4j;
	public DBUtils dbUtils;
	public FileUtils fileUtils;
	public JSUtils jsUtils;
	public RobotUtils robotUtils;
	public ScreenShot screenShot;
	public WebUtils webUtils;
	
	public BasePage(WebDriver driver,ExtentTest eTest,Logger log4j)
	{
		this.driver=driver;
		this.eTest=eTest;
		this.log4j=log4j;
		PageFactory.initElements(driver, this);
		dbUtils =new DBUtils(eTest, log4j);
		fileUtils=new FileUtils(eTest, log4j);
		jsUtils=new JSUtils(driver, eTest, log4j);
		robotUtils=new RobotUtils(eTest, log4j);
		screenShot=new ScreenShot(eTest, log4j);
		webUtils=new WebUtils(eTest, log4j);
	}
}
