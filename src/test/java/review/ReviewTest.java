package review;

import BaseTest.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ReviewTest extends BaseTest {
    @Test
    public void review(){
        var clickProduct=homePage.clickToAddReview();

        var review=clickProduct.product();
        review.clickToAddReview();
        review.selectStar(3);
        review.setReview("This description is in english");
        review.setAuthor("Lucas");
        review.setEmail("sas@gmail.com");
        review.clickCheckBox();
        review.clickSubmitBtn();

        assertTrue(review.successText("This description is in english"), "Review was not found in the reviews list");

    }
}
