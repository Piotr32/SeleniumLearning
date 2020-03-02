package com.travelers.helpers;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;


public class TestListener implements ITestListener {


    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("on Test Start");

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("on Test Success");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            System.out.println("on Test Failure");
            SeleniumHelper.takeScreenshot(DriverFactory.getDriver(DriverType.CHROME));
        } catch (IOException | NoSuchDriverExepction e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("on Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("on Test Failed But Within Success Percentage");
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println("on Test Failed With Timeout");
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("on start");
    }

    @Override
    public void onFinish(ITestContext context) {

    }
}

