package com.personal.saucedemo.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.personal.saucedemo.utils.ConfigProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import personal.saucedemo.tests.pages.LoginPage;

public class LoginToApplication extends BaseTest {
    @Test(description = "Valid username & password")
    public void test1() {
        ExtentTest test=threadLocalTest.get();
        test=extent.createTest("Verifying valid credentials");
        WebDriver driver=threadLocalDriver.get();
        driver.get(ConfigProperties.getProperty("appUrl"));
        //      Assert.assertEquals(driver.findElements(By.className("login_logo")).size() > 0, true, "Launched browser successfully");
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        System.out.println("Launched browser successfully");
       if(driver.findElements(By.className("app_logo")).size() > 0) {
           test.pass("Logged into app successfully", MediaEntityBuilder.createScreenCaptureFromPath(util.captureScreenshot(driver)).build());

         }
       else{
           test.fail("app login failed", MediaEntityBuilder.createScreenCaptureFromPath(util.captureScreenshot(driver)).build());

       }
    }

}
