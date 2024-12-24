package listners;

import Utility.JSONUtility;
import Utility.PropertyUtility;
import constants.Env;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import java.lang.ref.PhantomReference;

public class MyRetryAnalyser implements IRetryAnalyzer {
    private static final int MAX_NUMBER_OF_ATTEMPTS=JSONUtility.readJSON(Env.QA).getMAX_NUMBER_OF_ATTEMPTS();

    /*static {

        String maxAttemptsValue = PropertyUtility.readProperty(Env.QA, "MAX_NUMBER_OF_ATTEMPTS");
        MAX_NUMBER_OF_ATTEMPTS = maxAttemptsValue != null ? Integer.parseInt(maxAttemptsValue) : 1;
    }*/


    private static int currentAttempt=1;

    @Override
    public boolean retry(ITestResult result) {
        if(currentAttempt<=MAX_NUMBER_OF_ATTEMPTS){
            currentAttempt++;
            return true;
        }
        return false;
    }
}
