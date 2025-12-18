package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddReviewPage {
    private WebDriver driver;
    private By product=By.cssSelector(".woocommerce-loop-product__title");
    public AddReviewPage(WebDriver driver) {
        this.driver = driver;
    }
    public ProductDetails product(){
        driver.findElement(product).click();
        return new ProductDetails(driver);
    }
}
