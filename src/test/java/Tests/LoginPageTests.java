package Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestComponents.BaseTest;
import TestComponents.Listener;
import Utility.DataFromJson;
import pageObject.DashboardPage;
import pageObject.LoginPage;
@Listeners(Listener.class)
public class LoginPageTests extends BaseTest {
	DashboardPage dashboard;
	@Test(description= "Verify the loging functionality with valid credentials", dataProvider = "validLoginData")
	public void  loginValidationValid(HashMap <String,String> map) throws IOException {
		   
		   dashboard = login.loginToDashboard(map.get("user"),map.get("pass"));
		   String user = dashboard.getDashBoardUserName();
		   Assert.assertEquals(user, user);
	}
	

	
	@Test(testName = "loginValid",description= "Verify the loging functionality with invalid credentials", dataProvider = "invalidLoginData")
	public void  loginValidationInvalid(HashMap<String,String> map) throws IOException {
		   
		   login.login(map.get("user"),map.get("pass"));
		   String  errorMsg = login.getInvalidCreddentialsErrorMessage();
		   Assert.assertEquals(errorMsg, errorMsg);	 
		   System.out.println(errorMsg);
	}
	
	

	@Test(description= "Verify the loging functionality with UserID test box blank", dataProvider = "blankLoginData")
	public void  loginWithBlankUserID(HashMap<String,String> map) throws IOException {
		   
		  login.login(map.get("user"),map.get("pass"));
		  String  errorMsg = login.getBlankTextErrorMessage();
		   Assert.assertEquals(errorMsg, errorMsg);	 
		   System.out.println(errorMsg);
	}
	
	
    //These are the methods that provide data to test scripts
	@DataProvider
	public Object[][] validLoginData() throws IOException{
		// Provides the data from class it self
		/*HashMap <String, String> data = new  HashMap<>();
		data.put("user", "Admin");data.put("pass", "admin123");
		return new Object[][] {{data.get("user"),data.get("pass")},{"Admin","admin123"}};*/
		List<HashMap<String,String>> validCreds = DataFromJson.getData("/src/test/resources/testData/validLoginCredentials.json");
		return new Object [][] {{validCreds.get(0)},{validCreds.get(1)}};
		}
	
	
	@DataProvider
	public Object[][] invalidLoginData() throws IOException{
		List<HashMap<String,String>> validCreds = DataFromJson.getData("/src/test/resources/testData/invalidLoginCredentials.json");
		return new Object [][] {{validCreds.get(0)},{validCreds.get(1)}};
		}
	
	
	@DataProvider
	public Object[][] blankLoginData() throws IOException{
		List<HashMap<String,String>> validCreds = DataFromJson.getData("/src/test/resources/testData/blankCredentials.json");
		return new Object [][] {{validCreds.get(0)},{validCreds.get(1)}};
		}
	
}
	
	

