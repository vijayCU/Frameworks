package jsuse;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignValuetoHTMLfield4 {

	public static void main(String[] args) throws Exception {
// can enter value in textbox even it is disabled
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();	//Upcasting
		driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("D:\\Vijay Document\\Vijay_Workspace\\Maven_Automation\\src\\test\\resources\\demo.html");
		WebElement element = driver.findElement(By.id("t1"));
		
		JavascriptExecutor jse=(JavascriptExecutor) driver;  //Typecasting
		String input="HANUMAN";
		jse.executeScript("e=arguments[0];e.value=arguments[1]",element,input);
		jse.executeScript("val=arguments[0];alert(val),alert(arguments[1])","VIJAY","UDAGATTI");
	}
}
