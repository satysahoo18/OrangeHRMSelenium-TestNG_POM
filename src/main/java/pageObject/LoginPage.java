package pageObject;



import java.io.IOException;


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
	@FindBy(xpath="//span[text()='Required']")
	WebElement blankText;
	
	
    public void goToLoginPage(String url) {
		driver.get(url);
	}
	
	public void login(String username, String pass) throws IOException {
		userName.sendKeys(username);
		userPass.sendKeys(pass);
		submitBtn.click();
	}
	public String getInvalidCreddentialsErrorMessage() {
		return invalidCred.getText();
	}
	public String getBlankTextErrorMessage() {
		return blankText.getText();
	}
	
	
		
		public DashboardPage loginToDashboard(String username, String pass) throws IOException {
			userName.sendKeys(username);
			userPass.sendKeys(pass);
			submitBtn.click();
			return new DashboardPage(driver);
	}
}
