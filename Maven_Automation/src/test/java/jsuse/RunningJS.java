package jsuse;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RunningJS {

	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();	//Upcasting
		driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("D:\\Vijay Document\\Vijay_Workspace\\Maven_Automation\\src\\test\\resources\\demo.html");
		
		//Seleniumcode
		WebElement ele = driver.findElement(By.id("t1"));
		String val = ele.getAttribute("value");
		System.out.println(val);
		
		//JS code equivalant to above sleniumcode 
		JavascriptExecutor jse=(JavascriptExecutor) driver;  //Typecasting
		jse.executeScript("alert(document.getElementById('t1').value)");
		
		
//		jse.executeScript("alert('This is selenium Alert')");
		
//		jse.executeScript("My JS code will take 2 mins to run");//Send JS to browser & wait till browser
//		//completes the execution of JS
//		System.out.println("Hi- Will be printed after 2 mins");
//		
//		jse.executeAsyncScript("My JS code will take 2 mins to run");//Send JS to browser & it will not wait
//		//till the completion of the execution of JS
//		System.out.println("Bye- Will be printed Immediately");
	}
}
