package workingwithTable;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxinTable {

	public static void main(String[] args) throws Exception {
		// select JAVA checkbox
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();	
		driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("D:\\Vijay Document\\Vijay_Workspace\\Maven_Automation\\src\\test\\resources\\tableTest2.html");	
		WebElement table = driver.findElement(By.id("t1"));
		
		String exptValue="API";
		String msg=exptValue+" Not Found";
		
		String xp=".//input[@type='checkbox']";
		List<WebElement> allCB = table.findElements(By.xpath(".//tr"));
		for(int i=0;i<allCB.size();i++) {
			WebElement tr = allCB.get(i);
			List<WebElement> allTD = tr.findElements(By.xpath(".//td"));//for column
			for(int j=0;j<allTD.size();j++) {
				WebElement td = allTD.get(j);
				String actualValue = td.getText();
				if(actualValue.equals(exptValue))
				{
					int row=i+1;
					int col=j+1;
					msg=exptValue+" Found at row :"+row+" and column :"+col;
					tr.findElement(By.xpath(xp)).click();
					System.out.println(msg);
					break;				
				}
			}
		}
	}
}
