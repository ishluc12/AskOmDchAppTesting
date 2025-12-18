package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By search=By.cssSelector("input[type='search']");
    private By clickSearch=By.cssSelector("button[type='submit']");


    public SearchPage(WebDriver driver){
        this.driver = driver;
    }

    public void setname(String name){
        driver.findElement(search).sendKeys(name);
    }
    public ProductDetail clickToExpand(){
        driver.findElement(clickSearch).click();
        return new ProductDetail(driver);
    }

}
