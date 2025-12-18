package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;

public class NavbarCheckPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private Map<By, String> navLinks = new LinkedHashMap<>() {{
        put(By.linkText("Home"), "AskOmDch");
        put(By.linkText("Store"), "Store");
        put(By.linkText("Men"), "Men");
        put(By.linkText("Women"), "Women");
        put(By.linkText("Accessories"), "Accessories");
        put(By.linkText("Account"), "Account");
        put(By.linkText("About"), "About Us");
        put(By.partialLinkText("Contact"), "Contact Us");
        put(By.cssSelector("a[href='https://askomdch.com/cart/']"),"Cart");
    }};


    public NavbarCheckPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
      public String getExpectedLinkText(By link){
        return navLinks.get(link);
      }
      public Map<By, String> getNavLinks(){
        return navLinks;
      }
    public void clickLink(By link) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(link));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center', inline: 'center'});", element);
        try {
            element.click();
        } catch (org.openqa.selenium.StaleElementReferenceException e) {
            element = wait.until(ExpectedConditions.elementToBeClickable(link));
            element.click();
        }
    }

    public String getPageHeader() {
        WebElement header;
        try {
            header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
        } catch (Exception e) {
            header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h2")));
        }
        return header.getText().trim();
    }



}
