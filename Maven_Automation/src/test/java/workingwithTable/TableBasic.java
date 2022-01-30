package workingwithTable;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TableBasic {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();	
		driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("D:\\Vijay Document\\Vijay_Workspace\\Maven_Automation\\src\\test\\resources\\tableTest.html");	
		//count no of columns
		List<WebElement> c = driver.findElements(By.xpath("//th"));
		int colcount=c.size();
		System.out.println("No of cols: "+colcount);
		//count no of rows
		 List<WebElement> r = driver.findElements(By.xpath("//tr"));
		int rowcount= r.size();
		System.out.println("No of rows: "+rowcount);
		//print the content of table header
		for(WebElement header:c)
		{
			System.out.print(header.getText());
			System.out.print("	");
		}
		System.out.println();
		//print the content of table data
		List<WebElement> d = driver.findElements(By.xpath("//td"));
		for(WebElement data:d)
		{
			System.out.print(data.getText());
			System.out.print("	");
		}
		System.out.println();
		
		
		driver.close();

	}

}
