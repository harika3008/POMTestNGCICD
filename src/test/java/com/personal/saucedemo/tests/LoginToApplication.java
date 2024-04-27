package com.personal.saucedemo.tests;

import com.personal.saucedemo.utils.ConfigProperties;
import com.personal.saucedemo.utils.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import personal.saucedemo.tests.pages.LoginPage;

import java.time.Duration;

import static java.lang.Long.parseLong;

public class LoginToApplication  {
//WebDriver driver;
////    @BeforeMethod
////    public void setUp() {
////        // Initialize WebDriver
////
////        WebDriverManager.chromedriver().setup();
////        driver=new ChromeDriver();
////        driver.manage().window().maximize();
////    }
//    @Test
//    public void test1(){
//    //    DriverManager.getDriver();
//        WebDriverManager.chromedriver().setup();
//        driver=new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(parseLong(ConfigProperties.getProperty("implicitWait"))));
//        driver.get(ConfigProperties.getProperty("appUrl"));
//        LoginPage  loginPage = new LoginPage(driver);
//        Assert.assertEquals(driver.findElements(By.className("login_logo")).size()>0,true,"Launched browser successfully");
//       loginPage.login("standard_user","secret_sauce");
//        System.out.println("Launched browser successfully");
//        Assert.assertEquals(driver.findElements(By.className("app_logo")).size()>0,true,"Login to  browser successfully");
//driver.quit();
//    }

}
