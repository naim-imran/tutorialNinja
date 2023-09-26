package testListenersAndReporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.tutorialNinja.base.InitialComponents;

public class Extendreporter extends  InitialComponents {
	
	
	private ExtentReports extentReports;

	public ExtentReports getExtentReporter() {
		ExtentSparkReporter extentSparkReporter= new ExtentSparkReporter(System.getProperty("user.dir")+"\\testResultsAndScreecshoots\\report"+ getCurrentDateAndTime()+".html");
		extentSparkReporter.config().setDocumentTitle("Open Cart functional test");
		extentSparkReporter.config().setReportName("pen Cart functional test " + getCurrentDateAndTime());

		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		extentReports.setSystemInfo("Operating System ", System.getProperty("os.name"));
		return extentReports;
	}
}
