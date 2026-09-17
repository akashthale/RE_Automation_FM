package ExtentReportDemo;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Wrappers.TestLogger;

public class ExtentListnerClass implements ITestListener {

	ExtentSparkReporter htmlReporter;
	ExtentReports report;
	ExtentTest test;

	public void configureReport() {
		htmlReporter = new ExtentSparkReporter("Ripple effects extent report 1.html");
		report = new ExtentReports();
		report.attachReporter(htmlReporter);

		// environmental information
		report.setSystemInfo("Machine", "Dell");
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("browser", "Chrome");
		report.setSystemInfo("user name", "Akash");

		// configuration to change look and feel of report
		htmlReporter.config().setDocumentTitle("Ripple Effects Report");
		htmlReporter.config().setReportName("Ripple Effects");
		htmlReporter.config().setTheme(Theme.DARK);

	}

	@Override
	public void onStart(ITestContext context) {

		configureReport();

		System.out.println("on start method invoked");
	}

	@Override
	public void onTestStart(ITestResult result) {

		System.out.println("Test started: " + result.getName());

		// Create Extent test when test starts
		ExtentTest test = report.createTest(result.getName());

		// Store current ExtentTest in ThreadLocal
		TestLogger.setTest(test);

		TestLogger.info("Test execution started: " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		TestLogger.pass("Test case passed: " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {

		TestLogger.fail("Test case failed: " + result.getName());

		if (result.getThrowable() != null) {
			TestLogger.fail("Failure reason: " + result.getThrowable().getMessage());
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		TestLogger.info("Test case skipped: " + result.getName());
	}

	@Override
	public void onFinish(ITestContext context) {

		System.out.println("on finish method invoked");

		report.flush();

		TestLogger.removeTest();
	}
}