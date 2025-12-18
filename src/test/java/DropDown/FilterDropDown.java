package DropDown;

import BaseTest.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FilterDropDown extends BaseTest {
    @Test
    public void filterDropDown(){
        var filterDropdown=homePage.clickToFilter();
        filterDropdown.selectFilter("Men  (7)");
        String check=filterDropdown.selectedOption();
        assertEquals(check, "Men  (7)");
    }
}
