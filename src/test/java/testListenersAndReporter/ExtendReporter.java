package testListenersAndReporter;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.tutorialNinja.base.InitialComponents;

public class ExtendReporter extends InitialComponents {

	public ExtentReports getExtentReporter(String testName, String folderName) {
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + File.separator + "testResultsAndScreecshoots"+ File.separator  + folderName + File.separator + testName +" report " + getTimeStamp() + ".html");
		extentSparkReporter.config().setDocumentTitle("Open Cart Functional Test");
		extentSparkReporter.config().setReportName(testName + " " + getTimeStamp());

		ExtentReports extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		return extentReports;
	}
}
