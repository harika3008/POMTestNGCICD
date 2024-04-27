package personal.saucedemo.tests.pages;

import com.personal.saucedemo.tests.BaseTest;
import com.personal.saucedemo.utils.ConfigProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage  {
WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver=driver;
      //  this.driver=driver;
    }
 //  private WebDriver driver;
    private By userName= By.id("user-name");
    private By passWord= By.id("password");
    private By loginBtn=By.id("login-button");

//public LoginPage(WebDriver driver) {
  //  super(driver);
//}
public void open(){
    driver.get(ConfigProperties.getProperty("appUrl"));
}
    public void setUsername(String username){
        driver.findElement(userName).sendKeys(username);
    }
    public void setPassword(String password){
        driver.findElement(passWord).sendKeys(password);
    }
    public void clickLoginButton(){
        driver.findElement(loginBtn).click();
    }
    public void login(String username, String password) {
        setUsername(username);
        setPassword(password);
        clickLoginButton();
    }
}
