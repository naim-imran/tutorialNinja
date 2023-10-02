package testListenersAndReporter;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TestNGListeners extends Extendreporter implements ITestListener {

	private ThreadLocal<ExtentTest> ThreadLocalReport = new ThreadLocal<ExtentTest>();
	private ExtentReports extentReport;
	
	
	
	@Override
	public void onStart(ITestContext context) {
		extentReport = getExtentReporter(context.getName());
		cleanTestsBed();
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();
		ThreadLocalReport.remove();
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest report = extentReport.createTest(result.getMethod().getDescription());
		ThreadLocalReport.set(report);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ThreadLocalReport.get().log(Status.PASS, "Test passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ThreadLocalReport.get().log(Status.FAIL, "Test failed. " + result.getThrowable());
		
		WebDriver driver = null;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		
		try {
			ThreadLocalReport.get().addScreenCaptureFromPath(takeScreenShot(driver, result.getName()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		  ThreadLocalReport.get().log(Status.SKIP,"There is exception in execution and skipped for another try " + result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	/*
	 * @Override public void onTestFailedWithTimeout(ITestResult result) { }
	 */
}
