package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By qtyInput = By.cssSelector("input.qty");
    private By updateCartBtn = By.cssSelector("button[name='update_cart']");
    private By cartUpdatedMessage = By.cssSelector(".woocommerce-message");
    private By checkoutBtn = By.cssSelector("a[href='https://askomdch.com/checkout/']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait= new WebDriverWait(driver, Duration.ofSeconds(4));
    }
    public void increase() {
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(qtyInput));

        new Actions(driver)
                .moveToElement(input)
                .click(input)
                .sendKeys(Keys.ARROW_UP)
                .perform();
    }

    public void decrease() {
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(qtyInput));;

        new Actions(driver)
                .moveToElement(input)
                .click(input)
                .sendKeys(Keys.ARROW_DOWN)
                .perform();
    }

    public void clickUpdateCart(){
        WebElement button=wait.until(ExpectedConditions.elementToBeClickable(updateCartBtn));
        button.click();

        wait.until(ExpectedConditions.attributeToBe(updateCartBtn, "aria-disabled", "false"));
    }
    public int getQuantity(){
        WebElement input=wait.until(ExpectedConditions.visibilityOfElementLocated(qtyInput));
        return Integer.parseInt(input.getAttribute("value"));
    }
    public String getCartUpdatedMessage() {
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(cartUpdatedMessage));
        return message.getText();
    }
    public CheckoutPage clickToCheck(){
        driver.findElement(checkoutBtn).click();
        return new CheckoutPage(driver);
    }

}
