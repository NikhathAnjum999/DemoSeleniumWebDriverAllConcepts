package demoTest;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class MyListener implements ITestListener {
    public ExtentSparkReporter sparkReporter; 
    public ExtentReports extent; 
    public ExtentTest test; 

    public void onStart(ITestContext context) {
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/appReport.html");
        sparkReporter.config().setDocumentTitle("Automation Report"); 
        sparkReporter.config().setReportName("Functional Testing"); 
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName());
        System.out.println("ON Test Start: " + result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Passed");
        System.out.println("ON Test Success: " + result.getName());
    }

    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Test Failed");
        test.log(Status.FAIL, result.getThrowable());
        System.out.println("ON Test Failure: " + result.getName());
    }

    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Test Skipped");
        System.out.println("ON Test Skipped: " + result.getName());
    }

    public void onFinish(ITestContext context) {
        extent.flush();
    }
}