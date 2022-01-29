package testngcheck;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class SeleniumParallel {

	static{
		System.setProperty("WebDriver.chrome.driver","./driver/chromedriver.exe");
		System.setProperty("webDriver.gecko.driver", "./driver/geckodriver.exe");
	}
	
	@Parameters("browser")
	@Test
	public void testBrowser(String browser) throws InterruptedException {
		WebDriver driver;
		if(browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else
		{
			driver=new FirefoxDriver();
		}
		driver.get("http://google.com");
		for(int i=0;i<20;i++)
		{
			driver.findElement(By.name("q")).sendKeys("java");
			Thread.sleep(100);
			driver.findElement(By.name("q")).clear();
		}
		driver.close();
	}
}
