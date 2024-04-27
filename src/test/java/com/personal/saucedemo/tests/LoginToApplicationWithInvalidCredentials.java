package com.personal.saucedemo.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.personal.saucedemo.utils.ConfigProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import personal.saucedemo.tests.pages.LoginPage;
public class LoginToApplicationWithInvalidCredentials extends BaseTest{


    @Test(description = "Empty username")
    public void test1() {
        ExtentTest test=threadLocalTest.get();
        test=extent.createTest("Verifying empty username validation");
WebDriver driver=threadLocalDriver.get();
        driver.get(ConfigProperties.getProperty("appUrl"));
   //      Assert.assertEquals(driver.findElements(By.className("login_logo")).size() > 0, true, "Launched browser successfully");
      LoginPage loginPage=new LoginPage(driver);
        loginPage.login("", "secret_sauce");
        System.out.println("Launched browser successfully");
        if(driver.findElements(By.xpath("//h3[contains(text(),'Username is required')]")).size() > 0) {
            test.pass("Empty username error message validated successfully", MediaEntityBuilder.createScreenCaptureFromPath(util.captureScreenshot(driver)).build());

        }
        else{
            test.fail("Empty username error message validation failed", MediaEntityBuilder.createScreenCaptureFromPath(util.captureScreenshot(driver)).build());

        }
    }

    @Test(description = "Empty password")
    public void test2() {
        ExtentTest test=threadLocalTest.get();
        test=extent.createTest("Verifying empty password validation");
        WebDriver driver=threadLocalDriver.get();
        driver.get(ConfigProperties.getProperty("appUrl"));
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login("standard_user", "");
        System.out.println("Launched browser successfully");
        if(driver.findElements(By.xpath("//h3[contains(text(),'Password is required')]")).size() > 0) {
            test.pass("Empty Password error message validated successfully", MediaEntityBuilder.createScreenCaptureFromPath(util.captureScreenshot(driver)).build());

        }
        else{
            test.fail("Empty Password error message validation failed", MediaEntityBuilder.createScreenCaptureFromPath(util.captureScreenshot(driver)).build());

        }
    }

    @Test(description = "Invalid username/password")
    public void test3() {
        ExtentTest test=threadLocalTest.get();
        test=extent.createTest("Invalid username/password validation");
        WebDriver driver=threadLocalDriver.get();
        driver.get(ConfigProperties.getProperty("appUrl"));
        LoginPage loginPage=new LoginPage(driver);
          loginPage.login("standard_user", "secroioet_sauce");
      //  test.info("Launched browser successfully", MediaEntityBuilder.createScreenCaptureFromPath(util.captureScreenshot(driver)).build());

        System.out.println("Launched browser successfully");
        if(driver.findElements(By.xpath("//h3[contains(text(),'Username and password do not match any user in this service')]")).size() > 0) {
            test.pass("Invalid login details error message validated successfully", MediaEntityBuilder.createScreenCaptureFromPath(util.captureScreenshot(driver)).build());

        }
        else{
            test.fail("Invalid login details error message validation failed", MediaEntityBuilder.createScreenCaptureFromPath(util.captureScreenshot(driver)).build());

        }
    }
    }
