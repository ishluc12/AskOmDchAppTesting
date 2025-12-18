package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;

public class FilterByPrice {
    private WebDriver driver;
    private By filterButton = By.cssSelector(".price_slider_amount .button");


    public FilterByPrice(WebDriver driver){
        this.driver = driver;
    }

    public void setPriceRange(int minPrice, int maxPrice) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
                "jQuery('.price_slider').slider('values', [arguments[0], arguments[1]]);" +
                        "jQuery('input#min_price').val(arguments[0]);" +
                        "jQuery('input#max_price').val(arguments[1]);" +
                        "jQuery('.price_slider').trigger('slidechange');",
                minPrice, maxPrice
        );
    }



    public void clickFilterButton(){
        driver.findElement(filterButton).click();
    }

}