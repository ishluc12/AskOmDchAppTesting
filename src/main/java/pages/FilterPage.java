package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FilterPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private By filter=By.cssSelector("select[name='product_cat']");
    public FilterPage(WebDriver driver){
        this.driver = driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void selectFilter(String list){
        wait.until(ExpectedConditions.visibilityOfElementLocated(filter));
        new Select(driver.findElement(filter)).selectByVisibleText(list);
    }
    public String selectedOption(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(filter));
        return new Select(driver.findElement(filter)).getFirstSelectedOption().getText();
    }
}
