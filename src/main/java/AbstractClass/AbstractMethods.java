package AbstractClass;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractMethods {
	public WebDriverWait wait ;
	protected WebDriver driver;
	private JavascriptExecutor js;
	public AbstractMethods(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	
	public  void ElementVisibility( WebDriver driver, WebElement element) {
		
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	/**
	 * UserDropDown Tab method Actions
	 */
	@FindBy(css=".oxd-topbar-header div:nth-child(3) ul li span p")
	WebElement userName;
	public String getDashBoardUserName() {
		return userName.getText();
	}
	
	@FindBy(css=".oxd-topbar-header div:nth-child(3) ul li span")
	WebElement userDropdown;
	
	@FindBy(css= ".oxd-dropdown-menu li a")
	List<WebElement>  dropdownList;
	public List<String> getUserDropdown() {
		userDropdown.click();
		ElementVisibility(driver, dropdownList.get(1));
		List<String> dropdownListContent = dropdownList.stream().map(s->s.getText()).toList();
		return dropdownListContent;
	}
	
	@FindBy(xpath="//h6[text()='About']")
	WebElement aboutTitle;
	@FindBy(css="p[class*='title']")
	List<WebElement> aboutTitlesLists;
	
	@FindBy(css="p[class*='about-text']")
	List<WebElement> aboutTextsLists;
	
	@FindBy(xpath="//a[text()='About']")
	WebElement aboutElement;
	
	@FindBy(css=".oxd-dialog-sheet--shadow button:nth-child(1)")
	WebElement closeAbout;
	
	public HashMap<String, String> userDropdownAbout() {
		aboutElement.click();
		ElementVisibility(driver, aboutTitle);
		HashMap<String,String> content = new HashMap<String,String>();
		content.put("Title", aboutTitle.getText());
		int i=0;
		while(i<aboutTitlesLists.size()) {
			content.put(aboutTitlesLists.get(i).getText(), aboutTextsLists.get(i).getText());
			i++;
		}
		closeAbout.click();
		return content;
	}
	
	
	@FindBy(xpath="//*[text()='Support']")
	WebElement aboutSupport;
	
	@FindBy(css=".oxd-text.oxd-text--p.orangehrm-sub-title")
	WebElement supportTittle;
	
	public String userDropdownSupport() {
		aboutSupport.click();
		return supportTittle.getText();	
	}
	
	
	@FindBy(xpath="//*[text()='Change Password']")
	WebElement aboutChangePassword;
	
	@FindBy(css= ".orangehrm-main-title")
	WebElement changePasswordTittle;
	
	public String userDropdownChangePassword() {
		aboutChangePassword.click();
		return changePasswordTittle.getText();	
	}
	
	
	@FindBy(xpath="//*[text()='Logout']")
	WebElement aboutLogout;
	
	@FindBy(css= ".orangehrm-login-title")
	WebElement logoutTittle;
	
	public String userDropdownLogout() {
		aboutLogout.click();
		return logoutTittle.getText();	
	}
	
}
