package HYBD_FW;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupingDemo {
	
	@BeforeMethod(alwaysRun = true)
	public void login() {
		Reporter.log("Login",true);
	}
	
	@AfterMethod(alwaysRun = true)
	public void Logout() {
		Reporter.log("Logout",true);
	}
	
	@Test(priority = 1,groups="user")
	public void createUser() {
		Reporter.log("createUser",true);
	}
	
	@Test(priority = 2,groups = "user")
	public void editUser() {
		Reporter.log("editUser",true);
	}
	
	@Test(priority = 3,groups = "user")
	public void deleteUser() {
		Reporter.log("deleteUser",true);
	}
	
//-------------------------------------
	@Test(priority = 4,groups = "account")
	public void createAccount() {
		Reporter.log("createAccount",true);
	}
	
	@Test(priority = 5,groups = "account")
	public void editAccount() {
		Reporter.log("editAccount",true);
	}
	
	@Test(priority = 6,groups = "account")
	public void deleteAccount() {
		Reporter.log("deleteAccount",true);
	}
//------------------------------------------------
	@Test(priority = 7,groups = "product")
	public void createProduct() {
		Reporter.log("createProduct",true);
	}
	
	@Test(priority = 8,groups = "product")
	public void editproduct() {
		Reporter.log("editproduct",true);
	}
	
	@Test(priority = 9,groups = "product")
	public void deleteProduct() {
		Reporter.log("deleteProduct",true);
	}
}
