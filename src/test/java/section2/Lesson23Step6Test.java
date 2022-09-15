package section2;

import base.BaseTest;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
/*
Lesson 2.3.6
1. Открыть страницу http://suninjuly.github.io/redirect_accept.html
2. Нажать на кнопку
3. Переключиться на новую вкладку
4. Пройти капчу для робота (getValue() из BaseTest) и получить число-ответ
 */
public class Lesson23Step6Test extends BaseTest {
    @Test
    public void switchToNewWindow(){
        Selenide.open("http://suninjuly.github.io/redirect_accept.html");

        $(By.cssSelector("[type='submit']")).click();
        switchTo().window(1);

        int x = Integer.parseInt($(By.id("input_value")).getText());
        String value = getValue(x);

        $(By.id("answer")).sendKeys(value);
        $(By.cssSelector("[type='submit']")).click();

        Alert alert = switchTo().alert();
        String answer = alert.getText();

        Assertions.assertNotNull(answer, String.format("%s ответ к заданию не получен", getClass().getSimpleName()));
        System.out.println(getClass().getSimpleName() + " " + answer);
    }
}
