package DropDown;

import BaseTest.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DropDownTest extends BaseTest {
    @Test
    public void testDropDown(){
        var dropdown=homePage.clickDropdown();
        dropdown.selectElement("Sort by price: high to low");
        assertEquals(dropdown.chooseOption(), "Sort by price: high to low");
    }
}
