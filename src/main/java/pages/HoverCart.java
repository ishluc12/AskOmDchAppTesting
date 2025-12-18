package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HoverCart {
    private WebDriver driver;
    private WebDriverWait wait;
    private By cart= By.className("count");
    private By view = By.cssSelector(".button.wc-forward");



    public HoverCart(WebDriver driver) {
        this.driver = driver;
        this.wait= new WebDriverWait(driver,Duration.ofSeconds(10));
    }
    public void hoverOverCart(){
        WebElement cartIcon =
                wait.until(ExpectedConditions.visibilityOfElementLocated(cart));
        Actions actions = new Actions(driver);
        actions.moveToElement(cartIcon).perform();
    }
    public String getText() {
        WebElement viewCart =
                wait.until(ExpectedConditions.presenceOfElementLocated(view));
        return viewCart.getText();
    }
}
