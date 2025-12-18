package cartprocess;

import BaseTest.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class ScrollTest extends BaseTest {
    @Test
    public void scrollTest(){
        var scroll=homePage.clicklink();
        String[] products = {"Basic Blue Jeans", "Basic Blue Jeans", "Basic Blue Jeans"};
        scroll.addProductsToCart(products);
        var cart=scroll.clickCart();
        cart.increase();
        cart.increase();
        cart.decrease();
        cart.clickUpdateCart();
        cart.getQuantity();
        String text=cart.getCartUpdatedMessage();
        assertTrue(text.contains("Cart updated."), "incorrect");
        var checkout=cart.clickToCheck();
        checkout.setFName("lucas");
        checkout.setLName("luke");
        checkout.setCompany("W ltd");
        checkout.setCountry("United States (US)");
        checkout.setStreet("NewYork");
        checkout.setAppartment("Oponent");
        checkout.setTown("London");
        checkout.setState("California");
        checkout.setZip("00212");
        checkout.setPhone("044547282929");
        checkout.setEmail("chrisi2@example.com");
        checkout.sendText("I want good quality");
        checkout.paymentMethod("Cash on delivery");
        checkout.clickToPlaceOrder();
        String text2=checkout.getText();
        assertTrue(text2.contains("Thank you. Your order has been received."), "incorrect");

    }
}
