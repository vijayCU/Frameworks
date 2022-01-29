package HYBD_FW;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class MultipleTest2 extends Base_Annotations {
	
	@Test
	public void test() {
		Reporter.log("TEST 2",true);
	}
}
