package workingwithTable;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TableBasic5 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();	
		driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("D:\\Vijay Document\\Vijay_Workspace\\Maven_Automation\\src\\test\\resources\\tableTest.html");	
		
		String exptValue="C2";
		String msg=exptValue+" Not Found";
		
		WebElement table1 = driver.findElement(By.id("t1"));
		//Search for Index as row and column
		List<WebElement> allTR = table1.findElements(By.xpath(".//tr"));//for row
		for(int i=0;i<allTR.size();i++) {
			WebElement tr = allTR.get(i);
			List<WebElement> allTD = tr.findElements(By.xpath(".//td"));//for column
			for(int j=0;j<allTD.size();j++) {
				WebElement td = allTD.get(j);
				String actualValue = td.getText();
				if(actualValue.equals(exptValue))
				{
					int row=i+1;
					int col=j+1;
					msg=exptValue+" Found at row :"+row+" and column :"+col;
					break;//Remove break if multiple value of exptValue present and print it in this loop only
				}
			}
		}
		System.out.println(msg);
		driver.close();
	}
}
