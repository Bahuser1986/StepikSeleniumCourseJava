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
Lesson 2.2.3
1. Открыть страницу http://suninjuly.github.io/selects1.html
2. Посчитать сумму заданных чисел
3. Выбрать в выпадающем списке значение равное расчитанной сумме
4. Нажать кнопку "Submit"
 */
public class Lesson22Step3Test extends BaseTest {
    @Test
    public void findValueInList() {
        Selenide.open("http://suninjuly.github.io/selects1.html");

        int x = Integer.parseInt($(By.id("num1")).getText());
        int y = Integer.parseInt($(By.id("num2")).getText());
        String value = String.valueOf(x + y);

        $(By.id("dropdown")).selectOptionByValue(value);
        $(By.cssSelector("[type='submit']")).click();

        Alert alert = switchTo().alert();
        String answer = alert.getText();

        Assertions.assertNotNull(answer, String.format("%s ответ к заданию не получен", getClass().getSimpleName()));
        System.out.println(getClass().getSimpleName() + " " + answer);
    }
}
