package com.travelers.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.io.IOException;

public class reportTest {

    public static void main(String[] args) throws IOException {
        // klasy potrzebne do stworzenia raportów;
        // ExtentHtmlReporter html = new ExtentHtmlReporter("Extent.html");
        ExtentHtmlReporter reporter = new ExtentHtmlReporter("index.html");

        ExtentReports reports = new ExtentReports();
        reports.attachReporter(reporter);

        ExtentTest test = reports.createTest("Our first test");
        test.log(Status.INFO, "First step");
        test.log(Status.ERROR, "Second step");
        test.log(Status.DEBUG, "Third step");
        test.pass("Passed");
        String path = "\\home\\piotr\\IdeaProjects\\SeleniumLearning\\src\\main\\resources\\685000000.png";
        test.pass("Description", MediaEntityBuilder.createScreenCaptureFromPath(path).build());

        reports.flush();




    }
}

