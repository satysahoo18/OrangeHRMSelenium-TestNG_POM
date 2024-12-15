package TestComponents;



import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.LoginPage;

public class BaseTest {
	public WebDriver driver;
	public WebDriver driverInitializer(){
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}
	
	public LoginPage launchApplication(String url) {
		driver = driverInitializer();
		LoginPage login = new LoginPage(driver);
		login.goToLoginPage(url);
		return login;
	}
	
	
	  @AfterMethod public void closeBrowser() { driver.close(); }
	  
	  public String getScreenShot(WebDriver driver,String testName) throws IOException {
		 TakesScreenshot screenShot = (TakesScreenshot)driver;
		 File image = screenShot.getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(image, new File(System.getProperty("user.dir")+"//test-output//screenshots//"+ testName + ".png"));
		 return System.getProperty("user.dir")+"//test-output//screenshots//"+ testName + ".png";
	  }
	 
	  public ExtentReports getReport() {
		  ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//test-output//reports//index.html");
		  reporter.config().setDocumentTitle("OrangeHRM");
		  reporter.config().setReportName("Test Case Report");
		  ExtentReports reports = new ExtentReports();
		  reports.attachReporter(reporter);
		  return reports;
	  }
	
}
