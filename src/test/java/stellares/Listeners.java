package stellares;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import resourses.base;

import java.io.IOException;

public class Listeners implements ITestListener {
    base b = new base();

    public void onTestStart(ITestResult iTestResult) {

    }

    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getName() + " IS COMPLETED SUCCESSFULLY");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println(result.getName() + " HAS FAILED!!!");
        try {
            b.getScreenshot(result.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {

    }
}
