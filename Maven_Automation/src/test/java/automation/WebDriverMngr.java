package automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverMngr {
	
	@Test
	public void testA() {
		System.setProperty("wdm.cachePath", "./src/test/resources/");
//		WebDriverManager.chromedriver().driverVersion("91").setup();// If we want particular Version
		WebDriverManager.chromedriver().setup();// 	Download latest version
		String location = System.getProperty("webdriver.chrome.driver");
		System.out.println(location);
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://google.com");
		driver.quit();
	}
	
	
}
