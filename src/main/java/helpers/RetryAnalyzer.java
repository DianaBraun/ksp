package helpers;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int actualRetry = 0;
    private static final int MAX_RETRY = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (actualRetry < MAX_RETRY) {
            actualRetry++;
            return true;
        } else {
            return false;
        }
    }
}


