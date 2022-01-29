package HYBD_FW;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class MultipleTest1 extends Base_Annotations{
	
	@Test
	public void test() {
		Reporter.log("TEST 1",true);
	}
}
