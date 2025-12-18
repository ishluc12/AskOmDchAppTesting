package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HoverPage {
    private WebDriver driver;

    public HoverPage(WebDriver driver){
        this.driver = driver;
    }

    public String getHoverText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement miniCartText = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".woocommerce-mini-cart__total")
        ));

        return miniCartText.getText();
    }
}
