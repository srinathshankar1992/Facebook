package Resources;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ClassForRetry implements IRetryAnalyzer {

	int counter=0;
	int maxcount = 3;
	
	public boolean retry(ITestResult arg0) {
		// TODO Auto-generated method stub
		
		if(counter<maxcount)
		{
			counter++;
			return true;
		}
		
		
		return false;
	}

}
