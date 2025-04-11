package TestComponents;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Utility.EnvReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.LoginPage;

public class BaseTest {
	public WebDriver driver;
	public LoginPage login;
	
	public WebDriver driverInitializer(String browser){
		
		if(browser.contains("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		if(browser.contains("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}
	
	
	@Parameters("browser")
	@BeforeMethod(alwaysRun = true)

	public void launchApplication(String browser) throws FileNotFoundException, IOException {
//		browser= "chrome";
		driver = driverInitializer(browser);
		login = new LoginPage(driver);
		login.goToLoginPage(new EnvReader().getProperty("url"));
		
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
