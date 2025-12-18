package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By account = By.linkText("Account");
    private By store=By.linkText("Store");
    private By men=By.linkText("Men");
    private By navbar=By.cssSelector("a[href='https://askomdch.com/']");
    private By count = By.className("count");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public NavbarCheckPage clickLinks(){
        driver.findElement(navbar).click();
        return new NavbarCheckPage(driver);
    }
    public AccountCreationPage clickToRegister(){
        driver.findElement(account).click();
        return new AccountCreationPage(driver);
    }
    public LoginAccountPage clickToLogin(){
        driver.findElement(account).click();
        return new LoginAccountPage(driver);
    }
    public StoreClick clicklink(){
        driver.findElement(store).click();
        return new StoreClick(driver);
    }

    public NavbarCheckPage clickAllLink(){
        driver.findElement(men).click();
        return new NavbarCheckPage(driver);
    }
    public SortPage clickDropdown(){
        driver.findElement(store).click();
        return new SortPage(driver);
    }
    public FilterPage clickToFilter(){
        driver.findElement(store).click();
        return new FilterPage(driver);
    }
    public SearchPage clickToSearch(){
        driver.findElement(store).click();
        return new SearchPage(driver);
    }
    public FilterByPrice clickFilterPrice(){
        driver.findElement(store).click();
        return new FilterByPrice(driver);
    }

    public AddReviewPage clickToAddReview(){
        driver.findElement(store).click();
        return new AddReviewPage(driver);
    }
}
