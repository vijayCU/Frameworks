package workingwithTable;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RealTimeExonTable {
	
	// getting the element's column Index
	public static int columnIndex(WebElement table,String tableHeader) 
	{
		int index=0;
		List<WebElement> allheader = table.findElements(By.tagName("th"));
		for(int i=0;i<allheader.size();i++)
		{
			String actualValue = allheader.get(i).getText();
			if(actualValue.equals(tableHeader))
			{
				index=i+1;
				break;
			}
		}
		return index;		
	}
	
	//Searching Element's Row index
	public static int getRowIndex(WebElement table,int ColIndex,String searchvalue)
	{
		int index=0;
		String xp=".//td["+ColIndex+"]";
		System.out.println("Xpath is :"+xp);
		List<WebElement> allTD = table.findElements(By.xpath(xp));
		for(int i=0;i<allTD.size();i++)
		{
			String value = allTD.get(i).getText();
//			System.out.println(value);
			if(value.equals(searchvalue))
			{
				index=i+1;
				break;
			}
		}
		return index;
	}

	public static void selectItem(WebDriver driver,WebElement table,int rowIndex) throws Exception
	{
		
		String xp=".//tr["+rowIndex+"]//input[@type='checkbox']/../label";
//		System.out.println("Checkbox xpath is : "+xp );
		WebElement checkbox = table.findElement(By.xpath(xp));
		scroll(driver,checkbox);
//		Thread.sleep(600);
		checkbox.click();
	}
	
	public static boolean VerifyNextpagePresent(WebDriver driver,int pageIndex)
	{
		boolean present=false;
		 String currentPage = driver.findElement(By.xpath(".//a[@class='page-numbers current']")).getText();
		 if(currentPage.equals(String.valueOf(pageIndex)))
		 {
			 System.out.println("You are in Current Page");
			 present=true;
		 }
		 else
		 {
			 String xp=".//a[@class='page-numbers' and text()='"+pageIndex+"']";
//				System.out.println(xp);
				try {
					driver.findElement(By.xpath(xp));
					System.out.println("Page "+pageIndex+" is Present");
					present=true;
				}
				catch(Exception e)
				{
					System.out.println("Page "+pageIndex+" is Not Present");
					present=false;
				}
		 }
		return present;
	}
	
	public static void gotoNextPage(WebDriver driver,int pageIndex)
	{
		String xp=".//a[@class='page-numbers' and text()='"+pageIndex+"']";
		System.out.println(xp);
		try 
		{
			WebElement pageButton = driver.findElement(By.xpath(xp));
			scroll(driver,pageButton);
			pageButton.click();
			Thread.sleep(500);
		}
		catch(Exception e)
		{
			System.out.println("trouble in going to next page");
		}
	}
	
	public static void scroll(WebDriver driver,WebElement element)
	{
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true)", element);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws Exception {
		boolean productFound=false;
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();	
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.wooproducttable.com/demo-list/classic-table-01/");	
		int i=1;
		while(VerifyNextpagePresent(driver,i))
		{
			gotoNextPage(driver,i);
			Thread.sleep(1000);
			WebElement table = driver.findElement(By.xpath("//table"));
			int index = columnIndex(table,"Products");
//			System.out.println(index);
			int rowindex = getRowIndex(table,index,"manu Plugin Development"); //French Fries
			System.out.println("Index of product is :"+rowindex);
			if(rowindex>0)
			{
				productFound=true;
				System.out.println("Product Found in Page :"+i);
				selectItem(driver,table,rowindex);
				break;
			}
			else
			{
				System.out.println("Product Not Found in Page :"+i);
				System.out.println("Navagate to Next Page");
			}
			i++;
		}
		if(!productFound)
			System.out.println("sorry!!! Product not found");
		Thread.sleep(3000);
		driver.close();
	}
}
