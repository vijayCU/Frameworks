package robotuse;

import java.awt.Robot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RobotScroling {

	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.actimind.com/");
		Thread.sleep(1000);
		Robot r=new Robot();
		for(int i=1;i<=21;i++)
		{
			r.mouseWheel(1); // +ve number for scroll down
			Thread.sleep(500);
		}
		
		for(int i=1;i<=21;i++)
		{
			r.mouseWheel(-1); // -ve number for scroll up
			Thread.sleep(500);
		}
		Thread.sleep(500);
		driver.close();
	}
}
