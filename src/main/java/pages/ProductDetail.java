package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetail {
    private WebDriver driver;
    private By addCartButton=  By.cssSelector("button[name='add-to-cart']");;

    public  ProductDetail(WebDriver driver) {
        this.driver = driver;
    }

    public HoverCart addToCart(){
        driver.findElement(addCartButton).click();
        return new HoverCart(driver);
    }
}
