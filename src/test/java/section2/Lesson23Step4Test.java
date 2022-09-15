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
Lesson 2.3.4
1. Открыть страницу http://suninjuly.github.io/alert_accept.html
2. Нажать на кнопку
3. Принять confirm
4. На новой странице решить капчу для роботов(getValue() из BaseTest), чтобы получить число с ответом
 */
public class Lesson23Step4Test extends BaseTest {
    @Test
    public void acceptAlert(){
        Selenide.open("http://suninjuly.github.io/alert_accept.html");

        $(By.cssSelector("[type='submit']")).click();
        switchTo().alert().accept();

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
