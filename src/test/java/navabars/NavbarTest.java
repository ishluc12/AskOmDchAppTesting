package navabars;

import BaseTest.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class NavbarTest extends BaseTest {
    @Test
    public void navbarTest() {
        var navigstionbar = homePage.clickAllLink();
        for (By link : navigstionbar.getNavLinks().keySet()) {
            navigstionbar.clickLink(link);
            String expectedHeader = navigstionbar.getExpectedLinkText(link);
            String actualHeader = navigstionbar.getPageHeader();
            assertTrue(actualHeader.contains(expectedHeader), "Failed for link: " + link +
                            " Expected to contain: " + expectedHeader + " Actual: " + actualHeader);

        }
    }
}
