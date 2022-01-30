package jsuse;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollToElementMainpage {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();	//Upcasting
		driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://news.google.com/");	
		//scroling till element in main webpage
		WebElement sports = driver.findElement(By.xpath("//a[@href='./articles/CAIiEEImGBwCeyLbOMtbNUv1J48qGQgEKhAIACoHCAowj8n_CjDIrfkCMJWZ2AY?hl=en-IN&gl=IN&ceid=IN%3Aen\']"));
		int y=sports.getLocation().getY();
		System.out.println(y);
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0,"+y+")");
	
		 
	}
}
