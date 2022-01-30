package robotuse;

import java.awt.Robot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MoveMouseBtn {

	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.istqb.org/");
		WebElement abtus = driver.findElement(By.xpath("(//a[text()='About us '])[2]"));
//		Actions action=new Actions(driver);
//		action.moveToElement(abtus).perform();
		
		int x=abtus.getLocation().getX();//159
		System.out.println("x value :"+x);
		int y=abtus.getLocation().getY();//126
		System.out.println("y value :"+y);
		int w=(abtus.getSize().getWidth())/2;
		Thread.sleep(500);
		Robot r=new Robot();
		r.mouseMove(x+w, y+125);
	}
}
