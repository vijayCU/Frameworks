package jsuse;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RunningJS2 {

	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();	//Upcasting
		driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("D:\\Vijay Document\\Vijay_Workspace\\Maven_Automation\\src\\test\\resources\\demo.html");
	
		JavascriptExecutor jse=(JavascriptExecutor) driver;  //Typecasting
//		jse.executeScript("alert(document.getElementById('t1').value)");
		
		String v = (String) jse.executeScript("return document.getElementById('t1').value");
		System.out.println(v);
		

	}
}
