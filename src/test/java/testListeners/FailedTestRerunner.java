package testListeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class FailedTestRerunner implements IRetryAnalyzer {
	private byte retryCount= 0;
	private byte maxRetryCount= 2;
	@Override
	public boolean retry(ITestResult result) {
		if (retryCount< maxRetryCount) {
			retryCount++;
			return true;
		}
		return false;
	}

}
