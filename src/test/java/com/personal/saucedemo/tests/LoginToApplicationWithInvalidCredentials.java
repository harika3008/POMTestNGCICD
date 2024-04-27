package com.personal.saucedemo.tests;

import com.personal.saucedemo.utils.ConfigProperties;
import com.personal.saucedemo.utils.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import personal.saucedemo.tests.pages.LoginPage;

import java.time.Duration;

import static java.lang.Long.parseLong;

public class LoginToApplicationWithInvalidCredentials extends BaseTest{

 //   private LoginPage loginPage;
    private By userName= By.id("user-name");
    private By passWord= By.id("password");
    private By loginBtn=By.id("login-button");

    @Test(description = "Empty username")
    public void test1() {
WebDriver driver=threadLocalDriver.get();
        driver.get(ConfigProperties.getProperty("appUrl"));
   //      Assert.assertEquals(driver.findElements(By.className("login_logo")).size() > 0, true, "Launched browser successfully");
      LoginPage loginPage=new LoginPage(driver);
        loginPage.login("", "secret_sauce");
        System.out.println("Launched browser successfully");
        Assert.assertEquals(driver.findElements(By.xpath("//h3[contains(text(),'Username is required')]")).size() > 0, true, "Username field validated successfully");

    }

    @Test(description = "Empty password")
    public void test2() {
        WebDriver driver=threadLocalDriver.get();
        driver.get(ConfigProperties.getProperty("appUrl"));
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login("standard_user", "");
        System.out.println("Launched browser successfully");
        Assert.assertEquals(driver.findElements(By.xpath("//h3[contains(text(),'Password is required')]")).size() > 0, true, "Password field validated successfully");

    }

    @Test(description = "Invalid username/password")
    public void test3() {
        WebDriver driver=threadLocalDriver.get();
        driver.get(ConfigProperties.getProperty("appUrl"));
        LoginPage loginPage=new LoginPage(driver);
          loginPage.login("standard_user", "secroioet_sauce");
        System.out.println("Launched browser successfully");
        Assert.assertEquals(driver.findElements(By.xpath("//h3[contains(text(),'Username and password do not match any user in this service')]")).size() > 0, true, "User unable to login with invalid credentials");

    }
    }
