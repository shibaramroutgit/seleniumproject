package org.example.reportListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.example.base.TestBase;
import org.example.reporting.ReportMasterSetup;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class TestListener extends TestBase implements ITestListener {

    public static ExtentReports extentReports = ReportMasterSetup.extentReportSetup();
    public static ExtentTest extentTest;

    @Override
    public void onTestStart(ITestResult result) {
        //ITestListener.super.onTestSuccess(result);
        extentTest = extentReports.createTest(result.getTestClass().getName()+"_"+result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // It returns the class on which "onTestSuccess()" method run, it means current Test Class instance
        Object testClass = result.getInstance();
        // To get the driver which initialize at Base Class
        // Use the current Test Class reference and cast to Base class reference and call class  variable and methods
        WebDriver webDriver = ((TestBase)testClass).driver;
        try {
            ((TestBase)testClass).getScreenshotDriverAtListener(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        extentTest.pass("Message");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        //ITestListener.super.onTestFailure(result);
        extentTest.fail("Fail Message");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        //ITestListener.super.onTestSkipped(result);
        extentTest.skip("Skip Message");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        //ITestListener.super.onFinish(context);
        extentReports.flush();
    }
}
