package jsuse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadingHTML {

	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("D:\\Vijay Document\\Vijay_Workspace\\Maven_Automation\\src\\test\\resources\\demo.html");
		boolean isenabled = driver.findElement(By.id("t1")).isEnabled();
		System.out.println(isenabled);
//		driver.findElement(By.id("t1")).sendKeys("VIJAY");
		String v = driver.findElement(By.id("t1")).getAttribute("value");
		System.out.println(v);
		
	}
}
