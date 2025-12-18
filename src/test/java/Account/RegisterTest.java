package Account;

import BaseTest.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class RegisterTest extends BaseTest {
    @Test
    public void RegisterTest(){
        var register=homePage.clickToRegister();
        register.setName("chris12");
        register.setEmail("chrisi2@example.com");
        register.setPassword("chris123");
        register.clickToRegister();
        String text=register.getText();
        assertTrue(text.contains("Dashboard"), "Repeat again");

    }
}
