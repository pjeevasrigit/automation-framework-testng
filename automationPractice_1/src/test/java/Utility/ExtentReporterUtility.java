package Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;

public class ExtentReporterUtility {
    private static ExtentReports extentReports;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
    public static void setUpSparkReporter(String fileName){

        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"//"+fileName);
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
    }

    public static void createExtentTest(String testName){
        if (extentReports == null) {
            throw new IllegalStateException("ExtentReports is not initialized. Call setUpSparkReporter() first.");
        }
        ExtentTest test = extentReports.createTest(testName);
        extentTest.set(test);

    }



    public static ExtentTest getTest(){
        ExtentTest test = extentTest.get();
        if (test == null) {
            throw new IllegalStateException("ExtentTest is not initialized. Call createExtentTest() first.");
        }
        return test;

    }

    public static void flushReport() {
        if (extentReports == null) {
            throw new IllegalStateException("ExtentReports is not initialized. Call setUpSparkReporter() first.");
        }
        extentReports.flush(); // dump all logs in report
    }
}
