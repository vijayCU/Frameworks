package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;

public class Loginpage extends BasePage
{
	@FindBy(name="email")
	private WebElement unTB;
	
	@FindBy(name="pass")
	private WebElement pwTB;
	
	@FindBy(name="login")
	private WebElement loginBTN;
	
	public Loginpage(WebDriver driver,ExtentTest eTest,Logger log) {
		super(driver, eTest, log);
	}
	
	public void setUserName(String un)
	{
		webUtils.sendKeys(unTB, un);
		
	}
	public void setPassword(String pw)
	{
		webUtils.sendKeys(pwTB, pw);
	}
	
	public void clicklogin()
	{
		webUtils.click(loginBTN);
		
	}
}
