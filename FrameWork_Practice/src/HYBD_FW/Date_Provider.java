package HYBD_FW;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Date_Provider extends Base_Annotations{

	@DataProvider
	public Object[][] getdata(){
		Object[][] data= new Object[2][2];
		data[0][0]="Vijay";
		data[0][1]="Udagatti";
		
		data[1][0]="Ranebennur";
		data[1][1]=581115;
		return data;
	}
	@Test(dataProvider ="getdata")
		public void createuser(Object c1,Object c2) {
			Reporter.log(c1+" "+c2,true);
		}
}
