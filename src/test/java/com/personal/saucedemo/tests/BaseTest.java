package com.personal.saucedemo.tests;
import com.personal.saucedemo.utils.ConfigProperties;
import com.personal.saucedemo.utils.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static java.lang.Long.parseLong;

public  class BaseTest {
    static Properties properties=new Properties();
    protected ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
    @BeforeMethod(alwaysRun = true)
    public void Setup(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //set driver
        threadLocalDriver.set(driver);

        System.out.println("Before Test Thread ID: "+Thread.currentThread().getId());

        //get URL
  //      getDriver().get("https://www.saucedemo.com/");
    }

    //get thread-safe driver
//    public static WebDriver getDriver(){
//        return threadLocalDriver.get();
//    }


    @AfterMethod(alwaysRun = true)
    public void tearDown(){

        threadLocalDriver.get().quit();
        System.out.println("After Test Thread ID: "+Thread.currentThread().getId());

        threadLocalDriver.remove();
    }
}
