package keywrod_FrameWork;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import io.github.bonigarcia.wdm.WebDriverManager;

class Action{
	
	public static WebElement findElement(WebDriver driver,String xp,String input)
	{
	WebElement element = driver.findElement(By.xpath(xp));
		return element;
	}
	
	public static void sendKeys(WebDriver driver,String xp,String input)
	{
		 WebElement element = driver.findElement(By.xpath(xp));
		 element.sendKeys(input);
	}
	
	public static void click(WebDriver driver,String xp,String input)
	{
		 WebElement element = driver.findElement(By.xpath(xp));
		 element.click();
	}
	
	public static void VerifyElementPresent(WebDriver driver,String xpath,String input)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		try {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		System.out.println("Element is present");
		}
		catch(Exception e)
		{
			System.out.println("Element is Not present");
		}
	}
}

public class KeywordFW {
	
	public static WebDriver initApp() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		Recordset recordSet1 = getDataFromExcel("./src/test/resources/Keyword.xlsx","Config" );
		recordSet1.next();
		String url=recordSet1.getField("URL");
		long ito=Long.parseLong(recordSet1.getField("ITO"));
		
		driver.manage().timeouts().implicitlyWait(ito, TimeUnit.SECONDS);
		driver.get(url);
		
		return driver;
	}
	
	public static Recordset getDataFromExcel(String excelpath,String sheet) throws FilloException
	{
		Fillo fillo=new Fillo();
		Connection con = fillo.getConnection(excelpath);
		Recordset recordSet = con.executeQuery("select * from "+sheet);
		con.close();
		return recordSet;
	}
	
	public static void doAction(WebDriver driver,String xpath,String action,String input) throws InterruptedException 
	{
		//Find Element
		if(action.equalsIgnoreCase("sendKeys"))
		{
			Action.sendKeys(driver, xpath, input);
		}
		else if(action.equalsIgnoreCase("click"))
		{
			Action.click(driver, xpath,input);
		}
		else if(action.equalsIgnoreCase("VerifyElementPresent"))
		{
			Action.VerifyElementPresent(driver, xpath,input);
		}
		else
		{
			System.out.println("Invalid Action");
		}
		Thread.sleep(1000);
	}

	public static void executeSteps(WebDriver driver,String tc_name) throws Exception
	{
		Recordset recordSet = getDataFromExcel("./src/test/resources/Keyword.xlsx",tc_name );
		while(recordSet.next())
		{
			String xpath=recordSet.getField("xpath");
			String action=recordSet.getField("action");
			String input=recordSet.getField("input");
			
			doAction(driver,xpath,action,input);	
			Thread.sleep(1000);
		}
	}
	
	public static void executeScript(String tc_id) throws Exception
	{
		WebDriver driver = initApp();
		executeSteps(driver,tc_id);
		endApp(driver);
	}

	public static void endApp(WebDriver driver)
	{
		System.out.println("Done!!!");
		driver.close();
	}

	public static void main(String[] args) throws FilloException, Exception {
		
		Recordset recordSet = getDataFromExcel("./src/test/resources/Keyword.xlsx","Suite" );
		
		while(recordSet.next())
		{
			String tc_name=recordSet.getField("TCName");
			String execute=recordSet.getField("Status");
			if(execute.equalsIgnoreCase("Yes"))
			{
				System.out.println("Executing TestCase: "+tc_name);
				executeScript(tc_name);
			}
			else
			{
				System.out.println("Not Executing TestCase: "+tc_name);
			}
		}
	}
}
