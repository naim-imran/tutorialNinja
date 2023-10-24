package testListenersAndReporter;

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TestNGListeners extends ExtendReporter implements ITestListener {

	private ThreadLocal<ExtentTest> ThreadLocalReport = new ThreadLocal<ExtentTest>();
	private ExtentReports extentReport;
	private String folderName;
	
	@Override
	public void onStart(ITestContext context) {
		folderName = context.getName() + " " + getTimeStamp();
		File folder = new File("."+File.separator + "testResultsAndScreecshoots" + File.separator + folderName);
		folder.mkdirs();
		extentReport = getExtentReporter(context.getName(),folderName );
		//cleanTestsBed();
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		extentReport.setSystemInfo(System.getProperty("os.name"), System.getProperty("os.version"));
		HashMap<String, String> browserNameAndVersion = getBrowserNameVersion();
		extentReport.setSystemInfo(browserNameAndVersion.get("name"), browserNameAndVersion.get("version"));
		extentReport.setSystemInfo("java-version", System.getProperty("java.version"));
		
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

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			String screenshot = takeScreenShot(driver, result.getName(), folderName);
			ThreadLocalReport.get().addScreenCaptureFromPath(screenshot);
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ThreadLocalReport.get().log(Status.SKIP,
				"There is exception in execution and skipped for another try " + result.getThrowable());
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	}

}
