package workingwithTable;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TableBasic3 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();	
		driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("D:\\Vijay Document\\Vijay_Workspace\\Maven_Automation\\src\\test\\resources\\tableTest.html");	
		
		WebElement table1 = driver.findElement(By.id("t1"));
		//driver.findElement ex: webpage
		List<WebElement> allTR = driver.findElements(By.xpath("//tr"));
		System.out.println(allTR.size());

		//element.findElement ex: table is an element
		// "." is mandatory for finding ele in ele otherwise it will take page as whole
		List<WebElement> allTR1 = table1.findElements(By.xpath(".//tr"));
		System.out.println(allTR1.size());
		
		
		driver.close();

	}

}
