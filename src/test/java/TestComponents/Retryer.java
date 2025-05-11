package TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retryer implements IRetryAnalyzer{
   int i=1;
	@Override
	public boolean retry(ITestResult result) {
		
		while(i<3) {
			i++;
			System.out.println("Retry Case " +i+": " + result.getName());
			return true;
		}
		return false;
	}
	
}
