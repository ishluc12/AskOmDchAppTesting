package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginAccountPage {
    private WebDriver driver;
    private By username= By.id("username");
    private By password=By.id("password");
    private By check=By.name("rememberme");
    private By loginButton = By.cssSelector("button.woocommerce-form-login__submit");
    private By text= By.linkText("Dashboard");
    public LoginAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUsername(String name){
        driver.findElement(username).sendKeys(name);
    }
    public void setPassword(String pass){
        driver.findElement(password).sendKeys(pass);
    }
    public void clickCheck(){
        driver.findElement(check).click();
    }
    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }
    public String getDashboardText(){
        return driver.findElement(text).getText();
    }
}
