package section4;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import section4.pages.CartPage;
import section4.pages.MainPage;
import section4.pages.ProductPage;
/*
Lesson 4.3.10
Задание: наследование и отрицательные проверки
 */
public class Lesson43Step10Test extends BaseTest {
    private final static String URL = "http://selenium1py.pythonanywhere.com/ru/catalogue/coders-at-work_207/";
    /**
     * Гость открывает главную страницу.
     * Переходит в корзину по кнопке в шапке сайта.
     * Ожидаем, что в корзине нет товаров.
     * Ожидаем, что есть текст о том что корзина пуста.
     */
    @Test
    public void guestCanSeeProductInCartOpenedFromMainPage() {
        MainPage mainPage = new MainPage();
        mainPage.goToCart();
        CartPage cartPage = new CartPage();

        Assertions.assertFalse(cartPage.getCartItems().exists());

        Assertions.assertTrue(cartPage.getEmptyCartMessage().getText()
                .contains("Ваша корзина пуста"));
    }

    /**
     * Гость открывает страницу товара.
     * Переходит в корзину по кнопке в шапке.
     * Ожидаем, что в корзине нет товаров.
     * Ожидаем, что есть текст о том что корзина пуста.
     */
    @Test
    public void guestCanSeeProductInCartOpenedFromProductPage() {
        ProductPage productPage = new ProductPage(URL);
        productPage.goToCart();
        CartPage cartPage = new CartPage();

        Assertions.assertFalse(cartPage.getCartItems().exists());

        Assertions.assertTrue(cartPage.getEmptyCartMessage().getText()
                .contains("Ваша корзина пуста"));

    }
}
