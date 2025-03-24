package pageObject;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractClass.AbstractMethods;

public class DashboardPage extends AbstractMethods{
	public WebDriver driver;
	public  DashboardPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	

	
	@FindBy(xpath="//*[@class='oxd-topbar-header-title'] //*[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
	WebElement dashBoardTittle;
	
	public String getDashBoardTittle() {
		return dashBoardTittle.getText();
	}
	
	

	
}

