package grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//Standalone Grid
public class SeleniumGrid2 {

	@Parameters({"browser","gridURL"})
	@Test
	public void testBrowser(String browser,String gridURL) throws InterruptedException, MalformedURLException{
		
		URL whichURL=new URL(gridURL);
		DesiredCapabilities whichBrowser = new DesiredCapabilities();
		whichBrowser.setBrowserName(browser);
		
		WebDriver driver=new RemoteWebDriver(whichURL, whichBrowser);
		driver.get("http://www.google.com");
		
		
		
		
				
	}
}
