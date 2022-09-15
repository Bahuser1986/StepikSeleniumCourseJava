package section4;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import section4.pages.ProductPage;
/*
Lesson 4.3.2
1. Открываем страницу товара
2. Нажимаем на кнопку "Добавить в корзину".
*Посчитать результат математического выражения и ввести ответ.
    Ожидаемый результат:
1. Сообщение о том, что товар добавлен в корзину.
2. Название товара в сообщении должно совпадать с тем товаром, который вы действительно добавили.
3. Стоимость корзины совпадает с ценой товара.
 */
public class Lesson43Step2Test extends BaseTest {
    private static final String URL =
            "http://selenium1py.pythonanywhere.com/catalogue/the-shellcoders-handbook_209/?promo=newYear";
    @Test
    public void addToCartAndGetCode() {
        ProductPage productPage = new ProductPage(URL);
        productPage.clickOnAddToCart();
        productPage.solveQuiz();
        String code = productPage.getCode();

        System.out.println("Lesson 4.3.2 "+ code);

        Assertions.assertTrue(productPage.getAddedToCartMessage().getText()
                .contains("был добавлен в вашу корзину."),
                "Отсутствует сообщение, что товар добавлен в корзину");

        Assertions.assertEquals(productPage.getProductName().getText(),
                productPage.getActualProductName().getText(),
                "Не совпадают Названия товара до и после добавления в корзину");

        Assertions.assertEquals(productPage.getPrice().getText(),
                productPage.getCartPrice().getText(),
                "Не совпадают стоимость товара и стоимость корзины");
    }
}
