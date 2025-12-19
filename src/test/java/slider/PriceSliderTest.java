package slider;

import BaseTest.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class PriceSliderTest extends BaseTest {

    @Test
    public void PriceSliderTest() {

        var slider = homePage.clickFilterPrice();

        int minPrice = 30;
        int maxPrice = 70;

        slider.setPriceRange(minPrice, maxPrice);
        assertTrue(slider.arePricesWithinRange(minPrice, maxPrice),
                "Some products are outside the selected price range"
        );
    }
}
