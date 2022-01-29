package generic;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.RootLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(TestListeners.class)
public class BaseTest implements Iconstants{
	
	public WebDriver driver;
	public WebDriverWait wait;
	public ExtentTest eTest;
	public static ExtentReports extentReports;
	public Logger log4j;
	public DBUtils dbUtils;
	public FileUtils fileUtils;
	public JSUtils jsUtils;
	public RobotUtils robotUtils;
	public ScreenShot screenShot;
	public WebUtils webUtils;
	
	public BaseTest()
	{
		log4j=RootLogger.getLogger(this.getClass());
		dbUtils =new DBUtils(eTest, log4j);
		fileUtils=new FileUtils(eTest, log4j);
		jsUtils=new JSUtils(driver, eTest, log4j);
		robotUtils=new RobotUtils(eTest, log4j);
		screenShot=new ScreenShot(eTest, log4j);
		webUtils=new WebUtils(eTest, log4j);
	}
		
//	@BeforeSuite
//	public void startGrid() throws IOException
//	{
//		String[] command= {"cmd.exe","/C","Start","\\config\\RunMe.bat"};
//		Process p=Runtime.getRuntime().exec(command);
//	}
	
	@BeforeSuite
	public void initReport()
	{
		extentReports=new ExtentReports();
		String dateTime = FileUtils.currentDateTime();
		ExtentSparkReporter spark = new ExtentSparkReporter(EXTENTPATH+dateTime+".html");
		extentReports.attachReporter(spark);
	}
	
	@AfterSuite
	public void publishReport()
	{
		extentReports.flush();
	}
	
	@Parameters({"hubURL","browser"})
	@BeforeMethod
	public void preCondition(@Optional(DEFAULTHUBURL)String hubURL,@Optional(DEFAULTBROWSER)String browser,ITestResult testResult) throws Exception
	{
		String testname = testResult.getMethod().getMethodName();
		eTest = extentReports.createTest(testname);
		String usegrid = FileUtils.getPropertyValue(SETTINGSPATH,"grid");
		if(usegrid.equalsIgnoreCase("YES"))
		{
			eTest.log(Status.INFO, "Using grid");
			URL url=new URL(hubURL);
			eTest.log(Status.INFO, "HubURL is:"+hubURL);
			DesiredCapabilities capability=new DesiredCapabilities();
			capability.setBrowserName(browser);
			eTest.log(Status.INFO, "Browser is:"+browser);
			
			driver=new RemoteWebDriver(url, capability);
			driver.manage().window().maximize();
			
			EventFiringWebDriver eDriver=new EventFiringWebDriver(driver);
			eDriver.register(new WebListener(log4j));
			driver=eDriver;
		}
		else
		{
			eTest.log(Status.INFO, "Using Local sytem");
			String lbrowser = FileUtils.getPropertyValue(SETTINGSPATH, "localBrowser");
			if(lbrowser.equalsIgnoreCase("chrome"))
			{
			eTest.log(Status.INFO, "Application Running on CHROME");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			
			EventFiringWebDriver eDriver=new EventFiringWebDriver(driver);
			eDriver.register(new WebListener(log4j));
			driver=eDriver;
			}
			else 
			{
				eTest.log(Status.INFO, "Application Running on FIREFOX");
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
				driver.manage().window().maximize();
				
				EventFiringWebDriver eDriver=new EventFiringWebDriver(driver);
				eDriver.register(new WebListener(log4j));
				driver=eDriver;
			}
		}
		
		long eto = Long.parseLong(FileUtils.getPropertyValue(SETTINGSPATH,"ETO"));
		eTest.log(Status.INFO, "Explicit time out is: "+eto);
		wait = new WebDriverWait(driver, eto);
		
		long ito = Long.parseLong(FileUtils.getPropertyValue(SETTINGSPATH,"ITO"));
		eTest.log(Status.INFO, "Implicit time out is: "+ito);
		driver.manage().timeouts().implicitlyWait(ito, TimeUnit.SECONDS);
		
		long pto = Long.parseLong(FileUtils.getPropertyValue(SETTINGSPATH,"PTO"));
		eTest.log(Status.INFO, "Page loading time out is: "+pto);
		driver.manage().timeouts().pageLoadTimeout(pto,TimeUnit.SECONDS);
		
		long sto = Long.parseLong(FileUtils.getPropertyValue(SETTINGSPATH,"STO"));
		eTest.log(Status.INFO, "Script time out is: "+sto);
		driver.manage().timeouts().setScriptTimeout(sto,TimeUnit.SECONDS);
		
		String appurl = FileUtils.getPropertyValue(SETTINGSPATH,"AppURL");
		eTest.log(Status.INFO, "AppURL is: "+appurl);
		driver.get(appurl);
		
		driver.manage().deleteAllCookies();
		eTest.log(Status.INFO, "Cookies are Deleted");
		driver.manage().window().maximize();
		eTest.log(Status.INFO, "Window Maximized");
	}
	
	@AfterMethod
	public void postCondition(ITestResult result)
	{
		driver.quit();
		eTest.log(Status.INFO, "Closed the Browser");
		int status = result.getStatus();
		if(status==1)
		{
			eTest.log(Status.PASS, "Test Executed Sucessfully");
		}
		else if(status==2)
		{
			eTest.log(Status.FAIL, "Test Execution Failed");
		}
		else if(status==3)
		{
			eTest.log(Status.SKIP, "Test Excution Skipped");
		}
		else
		{
			eTest.log(Status.WARNING, "Test Execution is Unknown");
		}
	}
	
	@DataProvider
	public Iterator<String[]> getDataFromXL(Method method)
	{
		String sheet = method.getName();
		Iterator<String[]> data = FileUtils.getdatafromExcelforDP(EXCELPATH,sheet);
		return data;
	}
	
	@DataProvider
	public Iterator<String[]> getDataFromCSV(Method method)
	{
		String path = CSVPATH+method.getName()+".csv";
		Iterator<String[]> data = FileUtils.getdatafromCSVforDP(path);
		return data;		
	}
}
