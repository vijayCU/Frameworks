package generic;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class RobotUtils {
	
	Robot robot;
	public ExtentTest eTest;
	public Logger log4j;
	
	public RobotUtils(ExtentTest eTest,Logger log4j)
	{
		try 
		{
			robot=new Robot();
		} catch (AWTException e) 
		{
			e.printStackTrace();
		}
		this.eTest=eTest;
		this.log4j=log4j;
	}
	
	public void click(int x,int width,int y)
	{
		robot.mouseMove(x+width, y+Iconstants.SCROLLCONSTANT);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		eTest.log(Status.INFO,(" Element clicked using Robot"));
		log4j.info("Element clicked using Robot");
	}
	
	public void click(WebElement element)
	{
		int x=element.getRect().getX();
		int y=element.getRect().getY();
		int width=element.getRect().getWidth();
		
		robot.mouseMove(x+width, y+Iconstants.SCROLLCONSTANT);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		eTest.log(Status.INFO,("Element '"+element+"' clicked using Robot"));
		log4j.info("Element '"+element+"' clicked using Robot");
	}
	
	public void movetoElement(WebElement element)
	{
		eTest.log(Status.INFO,("Move to Element '"+element+"' using Robot"));
		log4j.info("Move to Element '"+element+"' using Robot");
		int x=element.getRect().getX();
		int y=element.getRect().getY();
		int width=element.getRect().getWidth();
		robot.mouseMove(x+width, y+Iconstants.SCROLLCONSTANT);
		
	}
	
	public void sendkeys(String input)
	{
		eTest.log(Status.INFO,("Enter the input "+input+" using Robot"));
		log4j.info("Enter the input "+input+" using Robot");
		
		char[] a = input.toUpperCase().toCharArray();
		for(char c:a)
		{
			int i=c;
			robot.keyPress(i);
			robot.keyRelease(i);
		}
	}
	
	public void mouseScrollDown(int noOfScroll)
	{
		eTest.log(Status.INFO,("Scroll Down  "+noOfScroll+" times using Robot"));
		log4j.info("Scroll Down  "+noOfScroll+" times using Robot");
		
		for(int i=1;i<=noOfScroll;i++)
		{
			robot.mouseWheel(1);
			try
			{
				Thread.sleep(Iconstants.SLEEP);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public void mouseScrollUp(int noOfScroll)
	{
		eTest.log(Status.INFO,("Scroll up  "+noOfScroll+" times using Robot"));
		log4j.info("Scroll up  "+noOfScroll+" times using Robot");
		
		for(int i=1;i<=noOfScroll;i++)
		{
			robot.mouseWheel(-1);
			try
			{
				Thread.sleep(Iconstants.SLEEP);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public void rightClick()
	{
		eTest.log(Status.INFO,("Right click on mouse using Robot"));
		log4j.info("Right click on mouse using Robot");
		
		robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
	}
}