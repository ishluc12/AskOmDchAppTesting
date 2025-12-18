package Account;

import BaseTest.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {
    @Test
    public void loginTest(){
        var login=homePage.clickToLogin();
        login.setUsername("chris");
        login.setPassword("chris123");
        login.clickCheck();
        login.clickLoginButton();
        String text=login.getDashboardText();
        assertTrue(text.contains("Dashboard"), "Repeat again");
    }
}
