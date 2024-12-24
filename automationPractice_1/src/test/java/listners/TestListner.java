package listners;

import Utility.BrowserUtility;
import Utility.ExtentReporterUtility;
import Utility.LoggerUtility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ui.tests.TestBase;

import java.io.IOException;
import java.util.Arrays;

public class TestListner implements ITestListener {
    Logger logger= LoggerUtility.getLogger(this.getClass());


    public void onTestStart(ITestResult result) {
        logger.info(result.getMethod().getMethodName());
        logger.info(result.getMethod().getDescription());
        logger.info(Arrays.toString(result.getMethod().getGroups()));


        ExtentReporterUtility.createExtentTest(result.getMethod().getMethodName());

    }
    public void onTestSuccess(ITestResult result) {
        logger.info(result.getMethod().getMethodName()+" "+"PASSED");
        ExtentReporterUtility.getTest().log(Status.PASS, result.getMethod().getMethodName()+" "+"PASSED");

    }
    public void onTestFailure(ITestResult result) {
        logger.error(result.getMethod().getMethodName()+" "+"FAILED");
        logger.error(result.getThrowable().getMessage());
        ExtentReporterUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName()+" "+"FAILED");
        ExtentReporterUtility.getTest().log(Status.FAIL,result.getThrowable().getMessage());
        Object testClass = result.getInstance();
        BrowserUtility browserUtility=((TestBase) testClass).getInstance();
        String screenshotPath;
        try {
            browserUtility.takeScreenshot(result.getMethod().getMethodName());
            screenshotPath=browserUtility.takeScreenshot(result.getMethod().getMethodName());
            ExtentReporterUtility.getTest().addScreenCaptureFromPath(screenshotPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    public void onTestSkipped(ITestResult result) {
        logger.info(result.getMethod().getMethodName()+" "+"SKIPPED");
        ExtentReporterUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName()+" "+"SKIPPED");
    }
    public void onStart(ITestContext context) {
        logger.info("Tst Suite Started");
        ExtentReporterUtility.setUpSparkReporter("report.html");

    }
    public void onFinish(ITestContext context) {
        logger.info("Tst Suite Completed");
       // extentReports.flush(); // dump all logs in report
    ExtentReporterUtility.flushReport();
    }
}
