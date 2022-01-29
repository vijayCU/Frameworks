package generic;

import org.apache.log4j.Logger;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class LogReport 
{
	public void logging(ExtentTest eTest,Logger log4j,String msg,Status status)
	{
		if(eTest!=null)
		{
			eTest.log(status, msg);
		}
		
		if(log4j!=null)
		{
			switch(status)
			{
				case PASS :
				case INFO : log4j.info(msg); break;
				case SKIP :
				case WARNING : log4j.warn(msg);break;
				case FAIL : log4j.error(msg); break;
			}
		}
	}
}
