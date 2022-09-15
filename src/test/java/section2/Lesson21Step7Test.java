package section2;

import base.BaseTest;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import java.util.Objects;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
/*
Lesson 2.1.7
1. Открыть страницу http://suninjuly.github.io/get_attribute.html.
2. Найти на ней элемент-картинку, который является изображением сундука с сокровищами.
3. Взять у этого элемента значение атрибута valuex, которое является значением x для задачи.
4. Посчитать математическую функцию от x (getValue() из BaseTest).
5. Ввести ответ в текстовое поле.
6. Отметить checkbox "I'm the robot".
7. Выбрать radiobutton "Robots rule!".
8. Нажать на кнопку "Submit".
 */
public class Lesson21Step7Test extends BaseTest {
    @Test
    public void clickCheckBoxes() {
        Selenide.open("http://suninjuly.github.io/get_attribute.html");

        int x = Integer.parseInt(Objects.requireNonNull($(By.id("treasure")).getAttribute("valuex")));
        String value = getValue(x);

        $(By.id("answer")).sendKeys(value);
        $(By.id("robotCheckbox")).click();
        $(By.id("robotsRule")).click();
        $(By.cssSelector("[type='submit']")).click();

        Alert alert = switchTo().alert();
        String answer = alert.getText();

        Assertions.assertNotNull(answer, String.format("%s ответ к заданию не получен", getClass().getSimpleName()));
        System.out.println(getClass().getSimpleName() + " " + answer);

    }
}
