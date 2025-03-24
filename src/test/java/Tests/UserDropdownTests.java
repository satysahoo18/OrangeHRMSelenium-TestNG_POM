package Tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import TestComponents.BaseTest;
import pageObject.DashboardPage;
import pageObject.LoginPage;

public class UserDropdownTests extends BaseTest{
	
	DashboardPage dashboard;
	
	 @BeforeMethod
	 public void prerequisites() throws FileNotFoundException, IOException {
		 
		 dashboard = login.loginToDashboard("Admin","admin123");
	 }
	@Test(description= "Verify user dropdown button and the elements links present in the list and ",
	      groups="UserDropdown")
	public void  UserDropdownListValidation() throws IOException {
		  
		   List<String> dropdownListContent = dashboard.getUserDropdown();
		   String [] expectedList = {"About", "Support", "Change Password", "Logout"};
		   Assert.assertEquals(Arrays.asList(expectedList), dropdownListContent);
	}
	
	@Test(description = "Verify the about tab in the user dropdown",groups="UserDropdown")
	public void userDropdownAboutElementValidation() throws IOException {
		   dashboard.getUserDropdown();
		   HashMap<String,String> content = dashboard.userDropdownAbout();
		   HashMap<String,String> expectContent = new  HashMap<String,String>();
		   expectContent.put("Title", "About");
		   expectContent.put("Company Name:", "OrangeHRM");
		   expectContent.put("Version:", "OrangeHRM OS 5.7");
		   expectContent.put("Active Employees:",content.get("Active Employees:") );
		   expectContent.put("Employees Terminated:", "0");
		   Assert.assertEquals(content, expectContent);

	}
	@Test(description = "Verify the Support tab in the user dropdown",groups="UserDropdown")
	public void userDropdownSupportElementValidation() throws IOException {
		 
		   dashboard.getUserDropdown();
		   String supportPageTittle = dashboard.userDropdownSupport();
		   Assert.assertEquals(supportPageTittle, "Customer Support");
		 
	}
	
	@Test(description = "Verify the change password tab in the user dropdown",groups="UserDropdown")
	public void userDropdownchangePasswordElementValidation() throws IOException {
		 
		   dashboard.getUserDropdown();
		   String changePassword = dashboard.userDropdownChangePassword();
		   Assert.assertEquals(changePassword, "Update Password");
	}
	
	@Test(description = "Verify the change password tab in the user dropdown",groups="UserDropdown")
	public void userDropdownLogoutElementValidation() throws IOException {
		
		   dashboard.getUserDropdown();
		   String supportPageTittle = dashboard.userDropdownLogout();
		   Assert.assertEquals(supportPageTittle, "Login");
	}
	
	
}
