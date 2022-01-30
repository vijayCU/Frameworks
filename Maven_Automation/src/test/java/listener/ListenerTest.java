package listener;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(ListenersImplemented.class) // Testng Listeners
public class ListenerTest {
	/*
	 * Used Ashot 1.5.4.jar for To scroll and taking screenshot of invisible area which is hidden in the current page
	 */
	@Test
	public void testA()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		EventFiringWebDriver edriver=new EventFiringWebDriver(driver);
		edriver.register(new SeleniumWebDriverListeners());
		
		edriver.get("https://www.google.com");
		edriver.findElement(By.name("q")).sendKeys("JAVA");
		edriver.close();
				
	}

}
