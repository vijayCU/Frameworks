package generic;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class WebUtils 
{
	public ExtentTest eTest;
	public Logger log4j;
	
	public WebUtils(ExtentTest eTest,Logger log4j)
	{
		this.eTest=eTest;
		this.log4j=log4j;
	}
	
	public void sendKeys(WebElement element,String input)
	{
		element.sendKeys(input);
		eTest.log(Status.INFO,"Entering the input :"+input);
		log4j.info("Entering the input :"+input);
	}
	
	public void click(WebElement element)
	{
		element.click();
		eTest.log(Status.INFO,"Clicking the Element");
		log4j.info("Clicking the Element");
	}
	
	public void submit(WebElement element)
	{
		element.submit();
	}

	public void clear(WebElement element)
	{
		element.clear();
	}
	
	public String getAttribute(WebElement element,String name)
	{
		String value=element.getAttribute(name);
		return value;
	}
	
	public String getCssValue(WebElement element,String name)
	{
		String value=element.getCssValue(name);
		return value;
	}
	
	public String getText(WebElement element)
	{
		String value=element.getText();
		return value;
	}
	
	public String getTagName(WebElement element)
	{
		String value=element.getTagName();
		return value;
	}
	
	public int getX(WebElement element)
	{
		int x=element.getLocation().getX();
		return x;
	}
	
	public int getY(WebElement element)
	{
		int y=element.getLocation().getX();
		return y;
	}
	
	public int getHeight(WebElement element)
	{
		int height=element.getRect().getHeight();
		return height;
	}
	
	public int getWidth(WebElement element)
	{
		int width=element.getRect().getWidth();
		return width;
	}
	
	public boolean isDisplayed(WebElement element)
	{
		boolean displayed = element.isDisplayed();	
		return displayed;
	}
	
	public boolean isEnabled(WebElement element)
	{
		boolean enabled = element.isEnabled();	
		return enabled;
	}
	
	public boolean isSelecteded(WebElement element)
	{
		boolean selected = element.isSelected();	
		return selected;
	}

}
