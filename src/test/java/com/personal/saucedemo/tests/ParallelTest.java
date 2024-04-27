package com.personal.saucedemo.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ParallelTest {


    @Test
    public void run1(){
        WebDriver driver;
       WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();

    driver.get("https://www.saucedemo.com/");
        System.out.println("Test 1");
        System.out.println(driver.getTitle());
    //    driver.quit();
    }

    @Test
    public void run2(){
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.google.com/");
        System.out.println("Test 2");
        System.out.println(driver.getTitle());
    //    driver.quit();
    }
    @Test
    public void run3(){
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.amazon.com/");
        System.out.println("Test 3");
        System.out.println(driver.getTitle());
     //   driver.quit();
    }


}
