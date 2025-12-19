package BaseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

public class BaseTest {
    private WebDriver driver;
    protected HomePage homePage;

    @BeforeMethod
    public void setUp(){
    System.setProperty("web.chrome.drive", "chromedriver.exe");
    driver = new ChromeDriver();
    driver.get("https://askomdch.com/");
    gohome();
    }

    public void gohome(){
        homePage = new HomePage(driver);
    }

//    @AfterMethod
//    public void quit(){
//        driver.quit();
//    }
}
