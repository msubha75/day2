package utils;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.service.ExtentService;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    private ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test: " + result.getMethod().getMethodName() + " is started");
        test = ExtentService.getInstance().createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test: " + result.getMethod().getMethodName() + "is passed");
        test.log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test: " + result.getMethod().getMethodName() + "is failed");
        test.log(Status.FAIL, "Test Failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test: " + result.getMethod().getMethodName() + "is skipped");
        test.log(Status.SKIP, "Test Skipped");
    }

}
