package HYBD_FW;

import org.bouncycastle.jce.provider.AnnotatedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.UnreachableBrowserException;


public class Test {

		public static void main(String[] args) throws AnnotatedException,IllegalStateException,UnreachableBrowserException, InterruptedException {
		System.out.println("Hello World !!!");
		System.setProperty("webdriver.gecko.driver","D:\\Vijay Document\\Vijay_Workspace\\Selenium_Practice\\Drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		Thread.sleep(2000);
		driver.get("https://in.search.yahoo.com/?fr2=inr");
		driver.findElement(By.xpath("//div[@class='text'][contains(.,'Sign In')]")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("vijay.19041986@yahoo.com");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("laxmi121218");
		driver.findElement(By.xpath("//button[@value='Next']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[contains(@class,'icon mail')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@role='presentation'][contains(.,'Vijay')]")).click();
		driver.findElement(By.xpath("//span[@class='_yb_m4qj8 _yb_1ol5u _yb_1jb8q _yb_rqr3j _yb_7lbcc'][contains(.,'Sign out')]")).click();
		Thread.sleep(6000);
	    driver.quit();
	    
		}
}

