package Hover;

import BaseTest.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HoverTest extends BaseTest {
    @Test
    public void HoverTest(){
        var search= homePage.clickToSearch();
        search.setname("Anchor Bracelet");
        var details=search.clickToExpand();
        var hover=details.addToCart();
        hover.hoverOverCart();
        String text = hover.getText();
        assertEquals(text,"VIEW CART");

    }
}
