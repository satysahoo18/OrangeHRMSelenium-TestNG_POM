package Tests;
import java.io.IOException;

import org.testng.*;
import org.testng.annotations.Test;

import TestComponents.BaseTest;
import TestComponents.Retryer;
import pageObject.DashboardPage;
import pageObject.LoginPage;

public class DashboardPageTests extends BaseTest {
	
	DashboardPage dashboard;
	@Test(retryAnalyzer = Retryer.class)
	public void pageScrolling() throws IOException, InterruptedException {
		dashboard=login.loginToDashboard("Admn", "admin123");
		String s  = dashboard.dashboardPageScroll("1000");
		
		
	}
}
