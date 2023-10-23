package testListenersAndReporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.tutorialNinja.base.InitialComponents;

public class ExtendReporter extends  InitialComponents {


	public ExtentReports getExtentReporter(String testName) {
		ExtentSparkReporter extentSparkReporter= new ExtentSparkReporter(System.getProperty("user.dir")+"\\testResultsAndScreecshoots\\"+testName+" report "+getTimeStamp()+".html");
		extentSparkReporter.config().setDocumentTitle("Open Cart functional test");
		extentSparkReporter.config().setReportName(testName + " " + getTimeStamp());

		ExtentReports extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		return extentReports;
	}
}
