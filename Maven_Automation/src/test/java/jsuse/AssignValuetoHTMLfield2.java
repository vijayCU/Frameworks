package jsuse;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignValuetoHTMLfield2 {

	public static void main(String[] args) throws Exception {
// can enter value in textbox even it is disabled
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();	//Upcasting
		driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("D:\\Vijay Document\\Vijay_Workspace\\Maven_Automation\\src\\test\\resources\\demo.html");
	
		JavascriptExecutor jse=(JavascriptExecutor) driver;  //Typecasting
		jse.executeScript("document.getElementsByName('n1')[0].value='SURYA'");//hardcoded
		String v="ADMIN";
		jse.executeScript("document.getElementsByName('n1')[0].value='"+v+"'");//passing value
	}
}
