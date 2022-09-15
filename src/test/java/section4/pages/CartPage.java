package section4.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CartPage {
    private static final String CART_URL = "http://selenium1py.pythonanywhere.com/ru/basket/";
    private final SelenideElement emptyCartMessage = $(By.cssSelector("#content_inner>p"));
    private final SelenideElement cartItems = $(By.cssSelector("basket_summary"));
    public CartPage() {
        Selenide.open(CART_URL);
    }

    public SelenideElement getEmptyCartMessage() {
        return emptyCartMessage;
    }

    public SelenideElement getCartItems() {
        return cartItems;
    }
}
