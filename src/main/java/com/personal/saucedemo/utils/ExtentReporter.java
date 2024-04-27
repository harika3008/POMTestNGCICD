package com.personal.saucedemo.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
    ExtentReports extent=new ExtentReports();
    ExtentSparkReporter sparkReporter=new ExtentSparkReporter("target/Spark.html");

    public void beforeTestMethod(){
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setDocumentTitle("Testng POM Framework - Parallel Execution");
        extent.attachReporter(sparkReporter);
    }
}
