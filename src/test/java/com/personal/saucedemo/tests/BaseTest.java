package com.personal.saucedemo.tests;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.personal.saucedemo.utils.WebUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.io.File;
import java.time.Duration;
import java.util.Properties;
public  class BaseTest {
    WebUtils util=new WebUtils();
    static Properties properties=new Properties();
    static public ExtentTest test;
    static public ExtentReports extent=new ExtentReports();
    String path=System.getProperty("user.dir")+ File.separator+"/reports"+File.separator+"Report"+System.currentTimeMillis()+".html";
    public ExtentSparkReporter spark = new ExtentSparkReporter(new File(path));
    protected ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
   protected ThreadLocal<ExtentTest> threadLocalTest = new ThreadLocal<>();

    @BeforeSuite
    public
    void startTest()
    {
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("New Project");
        extent.attachReporter(spark);
     }
     @AfterSuite
     public void afterSuite(){
        extent.flush();
     }


    @BeforeMethod(alwaysRun = true)
    public void Setup(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //set driver
        threadLocalDriver.set(driver);
        threadLocalTest.set(test);
        System.out.println("Before Test Thread ID: "+Thread.currentThread().getId());

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){

        threadLocalDriver.get().quit();
        System.out.println("After Test Thread ID: "+Thread.currentThread().getId());

        threadLocalDriver.remove();
    }
}
