package workingwithTable;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TableBasic4 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();	
		driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("D:\\Vijay Document\\Vijay_Workspace\\Maven_Automation\\src\\test\\resources\\tableTest.html");	
		
		String exptValue="A3";
		String msg=exptValue+" Not Found";
		String exptValue1="B2";
		String msg1=exptValue1+" Not Found";
		
		WebElement table1 = driver.findElement(By.id("t1"));
		List<WebElement> allTR = table1.findElements(By.xpath(".//tr"));
		for(WebElement tr:allTR) {
			List<WebElement> allTD = tr.findElements(By.xpath(".//th|.//td"));
			for(WebElement td:allTD) {
				System.out.print(td.getText()+" ");
			}
			System.out.println();
		}
		// search for element in header
		List<WebElement> allheader = table1.findElements(By.xpath(".//th"));
		for(WebElement header:allheader) {
			String actualValue = header.getText();
			if(actualValue.equals(exptValue))
			{
				msg="Found";
				break;
			}
		}
		System.out.println(msg);
		//Search for Index in header
		List<WebElement> allheaderIndex = table1.findElements(By.xpath(".//th"));
		for(int i=0;i<allheaderIndex.size();i++) {
			WebElement header = allheaderIndex.get(i);
			String actualValue1 = header.getText();
			if(actualValue1.equals(exptValue))
			{
				int col=i+1;
				msg=exptValue+" Found at column no :"+col;
				break;
			}
		}
		System.out.println(msg);
		
		//Search for Index in Non-header
		List<WebElement> allcells = table1.findElements(By.xpath(".//td"));
		for(int i=0;i<allcells.size();i++) {
			WebElement cell = allcells.get(i);
			String actualValue2 = cell.getText();
			if(actualValue2.equals(exptValue1))
			{
				int col=i+1;
				msg1=exptValue1+" Found at column no :"+col;
				break;
			}
		}
		System.out.println(msg1);
		driver.close();
	}
}
