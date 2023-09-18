package testListeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.tutorialNinja.base.InitialComponents;

public class TestNGListeners extends InitialComponents implements ITestListener {

	@Override
	public synchronized void onTestStart(ITestResult result) {
		System.out.println(result.getName() + " test case execution started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName() + " execution successfully finished");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getName() + " execution failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getName() + " execution was skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println(context.getName() + " started");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println(context.getName() + " finished");
	}

}
