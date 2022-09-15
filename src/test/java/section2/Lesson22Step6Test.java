package section2;

import base.BaseTest;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
/*
Lesson 2.2.6
1. Открыть страницу http://SunInJuly.github.io/execute_script.html.
2. Считать значение для переменной x.
3. Посчитать математическую функцию от x (getValue из BaseTest).
4. Проскроллить страницу вниз.
5. Ввести ответ в текстовое поле.
6. Выбрать checkbox "I'm the robot".
7. Переключить radiobutton "Robots rule!".
8. Нажать на кнопку "Submit".
 */
public class Lesson22Step6Test extends BaseTest {
    @Test
    public void scrollAndClickCheckBoxes() {
        Selenide.open("http://SunInJuly.github.io/execute_script.html");

        int x = Integer.parseInt($(By.id("input_value")).getText());
        String value = getValue(x);

        $(By.id("answer")).sendKeys(value);
        $(By.id("robotCheckbox")).click();
        $(By.id("robotsRule")).scrollTo().click();
        $x("//button[@type='submit']").click();

        Alert alert = switchTo().alert();
        String answer = alert.getText();

        Assertions.assertNotNull(answer, String.format("%s ответ к заданию не получен", getClass().getSimpleName()));
        System.out.println(getClass().getSimpleName() + " " + answer);
    }
}
