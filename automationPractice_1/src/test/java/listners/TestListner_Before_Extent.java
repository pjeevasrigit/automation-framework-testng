package listners;

import Utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class TestListner_Before_Extent implements ITestListener {
    Logger logger= LoggerUtility.getLogger(this.getClass());
    public void onTestStart(ITestResult result) {
        logger.info(result.getMethod().getMethodName());
        logger.info(result.getMethod().getDescription());
        logger.info(Arrays.toString(result.getMethod().getGroups()));
    }
    public void onTestSuccess(ITestResult result) {
        logger.info(result.getMethod().getMethodName()+" "+"PASSED");
    }
    public void onTestFailure(ITestResult result) {
        logger.info(result.getMethod().getMethodName()+" "+"FAILED");
        // not implemented
    }
    public void onTestSkipped(ITestResult result) {
        logger.info(result.getMethod().getMethodName()+" "+"SKIPPED");
    }
    public void onStart(ITestContext context) {
        logger.info("Tst Suite Started");
    }
    public void onFinish(ITestContext context) {
        logger.info("Tst Suite Completed");
    }
}
