package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FinalCheckPage {
    private WebDriver driver;
    private By text=By.className("woocommerce-order-details__title");
    public FinalCheckPage(WebDriver driver){
        this.driver = driver;
    }

}
