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
	@FindBy(xpath="//p[text()='My Actions']")
	WebElement scroll;
	
	@FindBy(xpath="//div[@class='oxd-grid-item oxd-grid-item--gutters orangehrm-dashboard-widget'][4]//div[@class='orangehrm-dashboard-widget-body --scroll-visible']")
	WebElement scrollbox;
	public String dashboardPageScroll(String value) throws InterruptedException {
		Thread.sleep(3000);
		scrollUpTo(value);
		Thread.sleep(3000);
		scrollToElement(scroll);
		Thread.sleep(3000);
		scrollIn(scrollbox);
		Thread.sleep(3000);	
		return scrollbox.getText()	;
	}

	
}

