package com.personal.saucedemo.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class WebUtils {

    public String captureScreenshot(WebDriver driver){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        File src= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest=new File(System.getProperty("user.dir")+File.separator+"screenshot"+File.separator+"/screenshot"+System.currentTimeMillis()+".png");
        String absPath=dest.getAbsolutePath();
        try{
            FileUtils.copyFile(src,dest);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return absPath;
    }
}
