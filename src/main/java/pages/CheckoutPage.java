package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CheckoutPage {
    private WebDriver driver;
    private By firstname= By.id("billing_first_name");
    private By lastname= By.id("billing_last_name");
    private By companyField= By.id("billing_company");
    private By countryField= By.id("billing_country");
    private By streetField= By.id("billing_address_1");
    private By appartmentField= By.id("billing_address_2");
    private By cityField= By.id("billing_city");
    private By stateField= By.id("billing_state");
    private By zipField= By.id("billing_postcode");
    private By phoneField= By.id("billing_phone");
    private By emailField= By.id("billing_email");
    private By textField= By.id("order_comments");
    private By paymentField =By.cssSelector("ul.wc_payment_methods label");
    private By placeOrderBtn=By.id("place_order");


    public CheckoutPage(WebDriver driver){
        this.driver=driver;
    }

    public void setFName(String fname){
        driver.findElement(firstname).sendKeys(fname);
    }
    public void setLName(String lname){
        driver.findElement(lastname).sendKeys(lname);
    }
    public void setCompany(String company){
        driver.findElement(companyField).sendKeys(company);
    }
    public void setCountry(String country){
       new Select(driver.findElement(countryField)).selectByVisibleText(country);
    }
    public void setStreet(String street){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(streetField);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.sendKeys(street);
    }
    public void setAppartment(String appartment){
        driver.findElement(appartmentField).sendKeys(appartment);
    }
    public void setTown(String town){
        driver.findElement(cityField).sendKeys(town);
    }
    public void setState(String state){
        new Select(driver.findElement(stateField)).selectByVisibleText(state);
    }
    public void setZip(String code){
        driver.findElement(zipField).sendKeys(code);
    }
    public void setPhone(String phone){
        driver.findElement(phoneField).sendKeys(phone);
    }
    public void setEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }
    public void sendText(String text){
        driver.findElement(textField).sendKeys(text);
    }
    public void paymentMethod(String paymentMethod){
        List<WebElement> methods = driver.findElements(paymentField);
        for (WebElement method : methods) {
            if(method.getText().contains(paymentMethod)){
                String txt = method.getAttribute("for");
                driver.findElement(By.id(txt)).click();
            }
        }
    }
    public void clickToPlaceOrder(){
        driver.findElement(placeOrderBtn).click();
    }
    private By successMessage = By.cssSelector(".woocommerce-notice.woocommerce-notice--success.woocommerce-thankyou-order-received");
    public String getText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return message.getText();
    }


}
