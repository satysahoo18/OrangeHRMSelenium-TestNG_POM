package TestComponents;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listener extends BaseTest implements ITestListener {
	WebDriver driver;
	ExtentReports reports = getReport();
	ExtentTest test;
	
	ThreadLocal<ExtentTest> thread = new ThreadLocal<ExtentTest>();
	 public  void onTestStart(ITestResult result) {
		    test= reports.createTest(result.getMethod().getMethodName());
		    thread.set(test);
		  }

		
		  public void onTestSuccess(ITestResult result) {
		   thread.get().log(Status.PASS,result.getTestName() + "is Passed");
		  }

		
		  public void onTestFailure(ITestResult result) {
		    thread.get().fail(result.getThrowable());
		    
		    try {
				driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		    String path = null;
		    try {
				path = getScreenShot(driver, result.getMethod().getMethodName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    thread.get().addScreenCaptureFromPath(path, result.getTestName());
		    
		  }

		
		  public void onTestSkipped(ITestResult result) {
		    // not implemented
		  }

		
		  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		    // not implemented
		  }

		 
		  public void onTestFailedWithTimeout(ITestResult result) {
		    onTestFailure(result);
		  }

		  public void onStart(ITestContext context) {
		    // not implemented
		  }

		
		  public void onFinish(ITestContext context) {
		    reports.flush();
		  }
}
