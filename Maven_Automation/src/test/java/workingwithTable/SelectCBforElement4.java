package workingwithTable;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectCBforElement4 {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();	
		driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("D:\\Vijay Document\\Vijay_Workspace\\Maven_Automation\\src\\test\\resources\\tableTest4.html");	
		// select checkbox if cols are dynamic
		WebElement table = driver.findElement(By.id("t1"));
		String reqcol="To BUY";
		String exptValue="JAVA";
		int col=0;
		List<WebElement> allheader = table.findElements(By.xpath(".//th"));
		for(int i=0;i<allheader.size();i++) {
			String actualcol = allheader.get(i).getText();
			if(actualcol.equalsIgnoreCase(reqcol)) {
				System.out.println(i);
				col=i+1;
			}
		}
		String xp=".//td[text()='"+exptValue+"']/../td["+col+"]/input";
		table.findElement(By.xpath(xp)).click();
	}
}
