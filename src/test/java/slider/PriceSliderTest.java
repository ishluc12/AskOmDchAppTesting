package slider;

import BaseTest.BaseTest;
import org.testng.annotations.Test;

import javax.swing.*;

public class PriceSliderTest extends BaseTest {
    @Test
    public void PriceSliderTest() {
        var slide=homePage.clickFilterPrice();
        slide.setPriceRange(30,70);
        slide.clickFilterButton();

    }

}
