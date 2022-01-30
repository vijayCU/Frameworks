package jsuse;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * ScrollBy(from current position)- Relative scroling
 * scrollTo(From Bigining)- Absolute scroling, negative values are not used
 */
public class ScrollingusingJS {

	public static void main(String[] args) throws Exception {
// can enter value in textbox even it is disabled
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();	//Upcasting
		driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.actimind.com/");
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0,100)"); 
		for(int i=1;i<22;i++) {
			jse.executeScript("window.scrollBy(0,100)");
			Thread.sleep(1000);
		}
		
		for(int i=1;i<22;i++) {
			jse.executeScript("window.scrollBy(0,-100)");
			Thread.sleep(1000);
		}
	}
}
