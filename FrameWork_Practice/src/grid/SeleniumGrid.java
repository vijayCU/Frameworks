package grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

//Standalone Grid
public class SeleniumGrid {

	@Test
	public void testBrowser() throws InterruptedException, MalformedURLException{
		URL whichURL=new URL("http://localhost:4444/wd/hub");
		DesiredCapabilities whichBrowser = DesiredCapabilities.chrome();
		WebDriver driver=new RemoteWebDriver(whichURL, whichBrowser);
		driver.get("http://www.google.com");
		
		
		
		
				
	}
}
