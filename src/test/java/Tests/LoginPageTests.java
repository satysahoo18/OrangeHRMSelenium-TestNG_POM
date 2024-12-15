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
import pageObject.LoginPage;
@Listeners(Listener.class)
public class LoginPageTests extends BaseTest {
	
	@Test(description= "Verify the loging functionality with valid credentials", dataProvider = "validLoginData")
	public void  loginValidationValid(HashMap <String,String> map) throws IOException {
		   LoginPage login =  launchApplication("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		   String user = login.login(map.get("user"),map.get("user"), true);
		   Assert.assertEquals(user, user);
		   
		   
	}
	
	@Test(description= "Verify the loging functionality with invalid credentials", dataProvider = "invalidLoginData")
	public void  loginValidationInvalid(HashMap<String,String> map) throws IOException {
		   LoginPage login =  launchApplication("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		   String  errorMsg = login.login(map.get("user"),map.get("pass"), false);
		   Assert.assertEquals(errorMsg, errorMsg);	
		   
	}
      
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
	
}
	
	

