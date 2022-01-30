package jsuse;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignValuetoHTMLfield5 {

	public static void main(String[] args) throws Exception {
// can enter value in textbox even it is disabled
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();	//Upcasting
		driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		driver.get("https://demo.actitime.com/login.do");
		
		Thread.sleep(1000);
		WebElement unTB = driver.findElement(By.id("username"));
		String un="admin";
		jse.executeScript("arguments[0].value=arguments[1]",unTB,un);
		
		Thread.sleep(1000);
		WebElement pwTB = driver.findElement(By.name("pwd"));
		String pw="manager";
		jse.executeScript("arguments[0].value=arguments[1]",pwTB,pw);
		
		Thread.sleep(1000);
		WebElement loginBtn = driver.findElement(By.id("loginButton"));
		jse.executeScript("arguments[0].click()",loginBtn);
	}
}
