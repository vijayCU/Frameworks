package jsuse;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollerInsideWebpage2 {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		//Handling Notifications pop up
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(option);	
		driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://www.fabindia.com/searchresults?search=shirt");	
		Thread.sleep(3000);
//		WebElement color = driver.findElement(By.xpath("//h3[text()='Color']"));
//		Thread.sleep(1000);
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0,50)");
	/*
	 * How to find inner scroll bar
	 * 1. In firefox element will have tooltip called Scroll
	 * 2. In Chrome element css will have property like "overflow-y:auto or overflow-y:auto	
	 * 
	 */
		WebElement element = driver.findElement(By.xpath("//h3[text()='Color']/../../div[2]"));
		for(int i=1;i<20;i++)
		{
		jse.executeScript("arguments[0].scrollBy(0,20)",element);
		}
		
		for(int i=1;i<20;i++)
		{
		jse.executeScript("arguments[0].scrollBy(0,-20)",element);
		}
		
	}
}
