package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountCreationPage {
    private WebDriver driver;
    private By usernameToRegister = By.cssSelector("#reg_username");
    private By emailToRegister = By.cssSelector("#reg_email");
    private By passwordToRegister = By.cssSelector("#reg_password");
    private By registerButton= By.name("register");
    private By text= By.linkText("Dashboard");



    public AccountCreationPage(WebDriver driver){
        this.driver = driver;
    }

    public void setName(String name){
        driver.findElement(usernameToRegister).sendKeys(name);
    }
    public void setEmail(String email){
        driver.findElement(emailToRegister).sendKeys(email);
    }
    public void setPassword(String password){
        driver.findElement(passwordToRegister).sendKeys(password);
    }
    public void clickToRegister(){
        driver.findElement(registerButton).click();
    }
    public String getText(){
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.visibilityOfElementLocated(text));
        return driver.findElement(text).getText();
    }
}
