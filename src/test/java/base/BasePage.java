package base;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

abstract public class BasePage {
    private final SelenideElement cart = $(By.cssSelector(".btn-group > a"));
    public void goToCart() {
        cart.click();
    }
}
