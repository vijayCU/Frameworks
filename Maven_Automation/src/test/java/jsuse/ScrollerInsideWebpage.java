package jsuse;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollerInsideWebpage {

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
		WebElement pink = driver.findElement(By.xpath("//span[text()='Pink']"));
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true)",pink);
//		jse.executeScript("arguments[0].click()",pink);
	}
}
