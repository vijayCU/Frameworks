package screnshotTaking;

import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ListenerTestandScreenshot {
	/*
	 * Used Ashot 1.5.4.jar for To scroll and taking screenshot of 
	 * invisible area which is hidden in the current page
	 */
	@Test
	public void testA() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.actimind.com");
		Thread.sleep(500);
		AShot ashot= new AShot();
		Screenshot image = ashot.shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		
		ImageIO.write(image.getImage(), "PNG",new File("APP_Image.png"));
		driver.close();
		
				
	}

}
