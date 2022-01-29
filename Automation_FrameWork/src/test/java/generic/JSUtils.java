package generic;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class JSUtils {
	WebDriver driver;
	JavascriptExecutor jse;
	public ExtentTest eTest;
	public Logger log4j;

	public JSUtils(WebDriver driver,ExtentTest eTest,Logger log4j)
	{
		this.driver=driver;
		jse=(JavascriptExecutor) driver;
		this.eTest=eTest;
		this.log4j=log4j;
	}
	public void sendkeys(WebElement element,String input)
	{
		eTest.log(Status.INFO,("Enter the input "+input+" using JSE"));
//		Use above Extent report or belowed log4j report as per requirement
		log4j.info("Enter the input "+input+" using JSE");
		
		jse.executeScript("arguments[0].value=arguments[1]",element,input);
	}
	
	public void clear(WebElement element)
	{
		eTest.log(Status.INFO,("Clear the Element "+element+" using JSE"));
		log4j.info("Clear the Element \"+element+\" using JSE");
		
		jse.executeScript("arguments[0].value=''",element);
	}
	
	public void click(WebElement element)
	{
		eTest.log(Status.INFO,("Click the Element "+element+" using JSE"));
		log4j.info("Click the Element \"+element+\" using JSE");
		
		jse.executeScript("arguments[0].click()",element);
	}
	
	public void scrollTo(int x,int y)
	{
		eTest.log(Status.INFO,("Scroll to the Elements("+x+","+y+") position using JSE"));
		log4j.info("Scroll to the Elements("+x+","+y+") position using JSE");
		
		jse.executeScript("window.scrollTo("+x+","+y+")"); 
	}
	
	public void scrollBy(int x,int y)
	{
		eTest.log(Status.INFO,("Scroll to the Elements("+x+","+y+") position using JSE"));
		log4j.info("Scroll to the Elements("+x+","+y+") position using JSE");
		
		jse.executeScript("window.scrollBy("+x+","+y+")"); 
	}
	
	public void scrollIntoView(WebElement element)
	{
		eTest.log(Status.INFO,("Scroll to the Element "+element+" position using JSE"));
		log4j.info("Scroll to the Element "+element+" position using JSE");
		
		jse.executeScript("arguments[0].scrollIntoView(true)",element);
	}
	
	public void scrollPageBottom()
	{
		eTest.log(Status.INFO,("Scroll to the Bottom of the page using JSE"));
		log4j.info("Scroll to the Bottom of the page using JSE");
		
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
}
