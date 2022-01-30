package keywrod_FrameWork;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Keyword {

	public static void main(String[] args) throws FilloException, Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.actitime.com/login.do");
		Fillo fillo=new Fillo();
		Connection con = fillo.getConnection("./src/test/resources/Keyword.xlsx");
		String query="select * from TC1";
		Recordset recordSet = con.executeQuery(query);
		
		while(recordSet.next())
		{
			String xpath=recordSet.getField("xpath");
			String action=recordSet.getField("action");
			String input=recordSet.getField("input");
			//Find element
			WebElement element = driver.findElement(By.xpath(xpath));
			//perform action
			if(action.equalsIgnoreCase("sendKeys"))
			{
				element.sendKeys(input);
			}
			else if(action.equalsIgnoreCase("click"))
			{
				element.click();
			}
			else
			{
				System.out.println("Invalid Action");
			}
			Thread.sleep(1000);
		}
		Thread.sleep(1000);
		con.close();
		System.out.println("Done!!!!");
		driver.close();
	}
}
