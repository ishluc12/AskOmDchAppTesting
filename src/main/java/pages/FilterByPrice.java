package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FilterByPrice {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By filterButton = By.cssSelector(".price_slider_amount .button");
    private By productPrices = By.cssSelector(".woocommerce-Price-amount.amount");

    public FilterByPrice(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Set price range using JavaScript (reliable for jQuery slider)
    public void setPriceRange(int minPrice, int maxPrice) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
                "jQuery('.price_slider').slider('values', [arguments[0], arguments[1]]);" +
                        "jQuery('#min_price').val(arguments[0]);" +
                        "jQuery('#max_price').val(arguments[1]);" +
                        "jQuery('.price_slider').trigger('slidechange');",
                minPrice, maxPrice
        );
    }

    // Click Filter button
    public void clickFilterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(filterButton)).click();
    }

    // Assertion helper: verify prices are within range
    public boolean arePricesWithinRange(int min, int max) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productPrices));

        List<WebElement> prices = driver.findElements(productPrices);

        for (WebElement price : prices) {
            String priceText = price.getText()
                    .replaceAll("[^0-9.]", "")
                    .trim();

            double value = Double.parseDouble(priceText);

            if (value < min || value > max) {
                return false;
            }
        }
        return true;
    }
}
