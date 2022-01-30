package robotuse;

import java.awt.Robot;
import java.awt.event.InputEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClickingButton {

	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.actitime.com/login.do");
		WebElement clickbtn = driver.findElement(By.id("loginButton"));
		int x=clickbtn.getLocation().getX();//794
		System.out.println("x value :"+x);
		int y=clickbtn.getLocation().getY();//378
		int w=(clickbtn.getSize().getWidth())/2;
		System.out.println("y value :"+y);
		Thread.sleep(500);
		Robot r=new Robot();
		r.mouseMove(x+w, y+120);
		r.mousePress(InputEvent.BUTTON1_MASK);
		r.mouseRelease(InputEvent.BUTTON1_MASK);
//		driver.close();
	}

}
