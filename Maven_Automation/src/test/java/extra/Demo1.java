package extra;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo1 {

	public static void main(String[] args) throws Exception {
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.kapoorlampshades.com/product-category/bathroom-lights/");
		WebElement filter = driver.findElement(By.xpath("//span[text()='Filter by price']"));
		int y=filter.getLocation().getY()-125;
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,"+y+")", filter);
		String sliderxp="//span[text()='Filter by price']/../../form/div/div/span[1]";
//		WebElement slider = driver.findElement(By.xpath(sliderxp));
		Thread.sleep(1000);
		Actions actions=new Actions(driver);
		for(int i=1;i<=20;i++)
		{
			WebElement slider = driver.findElement(By.xpath(sliderxp));
			actions.dragAndDropBy(slider, 1, 0).perform();
			Thread.sleep(100);
		}
		
		for(int i=1;i<20;i++)
		{
			WebElement slider = driver.findElement(By.xpath(sliderxp));
			actions.dragAndDropBy(slider, -10, 0).perform();
			Thread.sleep(100);
		}

	}

}
