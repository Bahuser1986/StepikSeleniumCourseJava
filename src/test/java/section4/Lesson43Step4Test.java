package section4;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import section4.pages.ProductPage;
/*
Lesson 4.3.4
Нужно определить, при каком значении параметра promo автотест упадет.
В качестве ответа на задание нужно ввести ссылку, на которой упал тест.
 */
public class Lesson43Step4Test extends BaseTest {
    @ParameterizedTest
    @ValueSource (strings = {
            "http://selenium1py.pythonanywhere.com/catalogue/coders-at-work_207/?promo=offer0",
            "http://selenium1py.pythonanywhere.com/catalogue/coders-at-work_207/?promo=offer1",
            "http://selenium1py.pythonanywhere.com/catalogue/coders-at-work_207/?promo=offer2",
            "http://selenium1py.pythonanywhere.com/catalogue/coders-at-work_207/?promo=offer3",
            "http://selenium1py.pythonanywhere.com/catalogue/coders-at-work_207/?promo=offer4",
            "http://selenium1py.pythonanywhere.com/catalogue/coders-at-work_207/?promo=offer5",
            "http://selenium1py.pythonanywhere.com/catalogue/coders-at-work_207/?promo=offer6",
            "http://selenium1py.pythonanywhere.com/catalogue/coders-at-work_207/?promo=offer7",
            "http://selenium1py.pythonanywhere.com/catalogue/coders-at-work_207/?promo=offer8",
            "http://selenium1py.pythonanywhere.com/catalogue/coders-at-work_207/?promo=offer9"
    })
    public void addToCartAndCheck(String url) {
        ProductPage productPage = new ProductPage(url);
        productPage.clickOnAddToCart();
        productPage.solveQuiz();

        Assertions.assertTrue(productPage.getAddedToCartMessage().getText()
                        .contains("был добавлен в вашу корзину."),
                "Отсутствует сообщение, что товар добавлен в корзину " + url);

        Assertions.assertEquals(productPage.getProductName().getText(),
                productPage.getActualProductName().getText(),
                "Не совпадают Названия товара до и после добавления в корзину " + url);

        Assertions.assertEquals(productPage.getPrice().getText(),
                productPage.getCartPrice().getText(),
                "Не совпадают стоимость товара и стоимость корзины " + url);
    }
}
