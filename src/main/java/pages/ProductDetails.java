package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductDetails {
    private WebDriver driver;
    private By linkToReview = By.cssSelector("a[href='#tab-reviews']");
    private By textArea=By.id("comment");
    private By author=By.id("author");
    private By email=By.id("email");
    private By CheckBox=By.id("wp-comment-cookies-consent");
    private By submitBtn=By.id("submit");
    private By SubmitteReview=By.cssSelector(".description");



    public ProductDetails(WebDriver driver){
        this.driver = driver;
    }

    public void clickToAddReview(){
        driver.findElement(linkToReview).click();
    }
    public void selectStar(int rating){
        List<WebElement> stars = driver.findElements(By.cssSelector("p.stars a"));
        if(rating < 1 || rating > stars.size()){
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }
       WebElement star= stars.get(rating - 1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'})", star);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(star)).click();
    }
    public void setReview(String text){
        driver.findElement(textArea).sendKeys(text);
    }
    public void setAuthor(String text){
        driver.findElement(author).sendKeys(text);
    }
    public void setEmail(String text){
        driver.findElement(email).sendKeys(text);
    }
    public void clickCheckBox(){
        driver.findElement(CheckBox).click();
    }
    public void clickSubmitBtn(){
        driver.findElement(submitBtn).click();
    }
    public boolean successText(String expectedResult){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
         wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(SubmitteReview));
        List<WebElement> allReview = driver.findElements(SubmitteReview);
        for(WebElement review:allReview){
            if(review.getText().trim().equals(expectedResult)){
                return true;
            };
        }
        return false;
    }

}
