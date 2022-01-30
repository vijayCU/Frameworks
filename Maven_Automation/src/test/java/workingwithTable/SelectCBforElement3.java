package workingwithTable;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectCBforElement3 {

	public static void main(String[] args) throws Exception {
		// select JAVA checkbox
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();	
		driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("D:\\Vijay Document\\Vijay_Workspace\\Maven_Automation\\src\\test\\resources\\tableTest3.html");	
		WebElement table = driver.findElement(By.id("t3"));
		String exptValue="API";
		
		String xp=".//td[text()='"+exptValue+"']/..//input[@type='checkbox']";
		table.findElement(By.xpath(xp)).click();
	}
}
