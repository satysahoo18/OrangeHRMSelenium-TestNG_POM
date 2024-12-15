package pageObject;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import AbstractClass.AbstractMethods;

public class LoginPage extends AbstractMethods {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
    public void goToLoginPage(String url) {
		driver.get(url);
	}
	
	@FindBy(xpath="//*[@name='username']")
	WebElement userName;
	
	@FindBy(xpath="//*[@type='password']")
	WebElement userPass;
	
	@FindBy(css="button[class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")
	WebElement submitBtn;
	
	@FindBy(css=".oxd-userdropdown-name")
	WebElement user;
	@FindBy(css=".oxd-alert-content.oxd-alert-content--error")
	WebElement invalidCred;
	
	public String login(String username, String pass, boolean shouldLoginSucceed) throws IOException {
		userName.sendKeys(username);
		userPass.sendKeys(pass);
		submitBtn.click();
	if(shouldLoginSucceed){
	
		return user.getText();
		
		 
		}
	
	else{
			return invalidCred.getText();
		}
	
		
	}
}
