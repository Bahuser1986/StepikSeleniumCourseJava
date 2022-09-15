package section4;

import base.BaseTest;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import section4.pages.ProductPage;
import java.util.function.BooleanSupplier;
/*
Lesson 4.3.6
Задание: отрицательные проверки
 */
public class Lesson43Step6Test extends BaseTest {
    private final static String URL = "http://selenium1py.pythonanywhere.com/ru/catalogue/coders-at-work_207/";

    /**
     * Открываем страницу товара.
     * Добавляем товар в корзину.
     * Проверяем, что нет сообщения об успехе.
     */
    @Test
    public void cantSeeSuccessMessageAfterAddingToCart() {
        ProductPage productPage = new ProductPage(URL);
        productPage.clickOnAddToCart();
        Assertions.assertFalse(productPage.getAddedToCartMessage().isDisplayed(),
                "Присутствует сообщение, что товар добавлен в корзину");
    }

    /**
     * Открываем страницу товара.
     * Проверяем, что нет сообщения об успехе.
     */
    @Test
    public void cantSeeSuccessMessage() {
        ProductPage productPage = new ProductPage(URL);
        Assertions.assertFalse(productPage.getAddedToCartMessage().isDisplayed(),
                "Присутствует сообщение, что товар добавлен в корзину");
    }

    /**
     * Открываем страницу товара.
     * Добавляем товар в корзину.
     * Проверяем, что сообщения об успехе пропало.
     */
    @Test
    public void messageDisappearedAfterAddingToCart() {
        ProductPage productPage = new ProductPage(URL);
        productPage.clickOnAddToCart();
        Assertions.assertTrue((BooleanSupplier) productPage.getAddedToCartMessage()
                .should(Condition.disappear));
    }
}
