package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StoreClick {

    private WebDriver driver;
    private WebDriverWait wait;
    private By count=By.className("count");

    public StoreClick(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void addProductsToCart(String[] products) {
        for (String product : products) {
            By addToCartBtn = By.xpath("//a[contains(@class,'add_to_cart_button') " + "and contains(@aria-label,'" + product + "')]");
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
            button.click();
            wait.until(ExpectedConditions.attributeContains(addToCartBtn, "class", "added"));
        }
    }
    public CartPage clickCart(){
        driver.findElement(count).click();
        return new CartPage(driver);
    }
}
