package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class SortPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By orderBy = By.cssSelector("select[name='orderby']");

    public SortPage(WebDriver driver){
        this.driver = driver;
         this.wait= new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    public void selectElement(String list){
        new Select(driver.findElement(orderBy)).selectByVisibleText(list);
    }
    public String chooseOption(){
        return new Select(driver.findElement(orderBy)).getFirstSelectedOption().getText();
    }

}
