package pages;

import org.openqa.selenium.*;
import java.util.ArrayList;
import java.util.List;

public class FilterByPrice {

    private WebDriver driver;
    private JavascriptExecutor js;

    private By filterButton = By.cssSelector(".price_slider_amount .button");
    private By priceSliderForm = By.className("price_slider_wrapper");
    private By minPriceInput = By.id("min_price");
    private By maxPriceInput = By.id("max_price");
    private By productPrices = By.cssSelector("ul.products li.product .woocommerce-Price-amount.amount");

    public FilterByPrice(WebDriver driver){
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
    }

    // Sets price range and clicks filter
    public void setPriceRange(int minPrice, int maxPrice){
        WebElement priceRangeForm = driver.findElement(priceSliderForm);

        js.executeScript(
                "arguments[0].scrollIntoView({block:'center'});" +
                        "document.getElementById('min_price').value=arguments[1];" +
                        "document.getElementById('max_price').value=arguments[2];",
                priceRangeForm, minPrice, maxPrice
        );

        driver.findElement(filterButton).click();
    }

    // Returns all displayed product prices
    public List<Double> getDisplayedProductPrices() {
        List<WebElement> priceElements = driver.findElements(productPrices);
        List<Double> prices = new ArrayList<>();

        for (WebElement price : priceElements) {
            String text = price.getText()
                    .replaceAll("[^0-9.]", "")
                    .trim();

            prices.add(Double.parseDouble(text));
        }
        return prices;
    }

    // ✅ ASSERTION HELPER
    public boolean arePricesWithinRange(int min, int max) {
        for (double price : getDisplayedProductPrices()) {
            if (price < min || price > max) {
                return false;
            }
        }
        return true;
    }
}
