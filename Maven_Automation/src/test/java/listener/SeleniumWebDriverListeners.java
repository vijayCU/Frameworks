package listener;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class SeleniumWebDriverListeners implements WebDriverEventListener{
	
	Logger log=Logger.getRootLogger();
	
	
	public void beforeNavigateTo(String url, WebDriver driver) {
		log.info("Entering URL :"+url);
		
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		log.info("URL Entered was :"+url);
		String title=driver.getTitle();
		log.info("Page loaded is :"+title);
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		log.info("Finding Element");		
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		log.info("Finding the Element successfull :"+element.getAttribute("name"));
		
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Before clicking Element");
		
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("After clicking Element");
		
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		log.info("Befor typing Element into :"+element.getAttribute("name"));
		
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		String input="";
		for(CharSequence c:keysToSend) {
			input=input+c.toString();
		}
		log.info("After typing Input'"+input+ "' into :"+element.getAttribute("name"));
	}



	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

		public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void onException(Throwable throwable, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub
		
	}

	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub
		
	}

	public void beforeGetText(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterGetText(WebElement element, WebDriver driver, String text) {
		// TODO Auto-generated method stub
		
	}

}
