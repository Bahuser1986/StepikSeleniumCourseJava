package section2;

import base.BaseTest;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
/*
Lesson 2.4.8
1. Открыть страницу http://suninjuly.github.io/explicit_wait2.html
2. Дождаться, когда цена дома уменьшится до $100 (ожидание нужно установить не меньше 12 секунд)
3. Нажать на кнопку "Book"
4. Решить уже известную нам математическую задачу (используйте ранее написанный код getValue() из BaseTest) и отправить решение
 */
public class Lesson24Step8Test extends BaseTest {
    @Test
    public void waitForElement() {
        Selenide.open("http://suninjuly.github.io/explicit_wait2.html");

        $(By.id("price")).shouldHave(Condition.text("$100"), Duration.ofSeconds(15));
        $(By.id("book")).click();

        int x = Integer.parseInt($(By.id("input_value")).getText());
        String value = getValue(x);

        $(By.id("answer")).sendKeys(value);
        $(By.id("solve")).click();

        Alert alert = switchTo().alert();
        String answer = alert.getText();

        Assertions.assertNotNull(answer, String.format("%s ответ к заданию не получен", getClass().getSimpleName()));
        System.out.println(getClass().getSimpleName() + " " + answer);
    }
}
