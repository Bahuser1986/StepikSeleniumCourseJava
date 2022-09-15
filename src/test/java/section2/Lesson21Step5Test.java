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
Lesson 2.1.5
1. Открыть страницу https://suninjuly.github.io/math.html.
2. Считать значение для переменной x.
3. Посчитать математическую функцию от x.
    def calc(x):
      return str(math.log(abs(12*math.sin(int(x)))))
4. Ввести ответ в текстовое поле.
5. Отметить checkbox "I'm the robot".
6. Выбрать radiobutton "Robots rule!".
7. Нажать на кнопку Submit.
 */
public class Lesson21Step5Test extends BaseTest {

    @Test
    public void clickCheckBoxes() {
        Selenide.open("https://suninjuly.github.io/math.html");

        int x = Integer.parseInt($(By.id("input_value")).getText());
        String value = getValue(x);

        $(By.id("answer")).sendKeys(value);
        $(By.id("robotCheckbox")).click();
        $(By.id("robotsRule")).click();
        $(By.cssSelector("button[type='submit']")).click();

        Alert alert = switchTo().alert();
        String answer = alert.getText();

        Assertions.assertNotNull(answer, String.format("%s ответ к заданию не получен", getClass().getSimpleName()));
        System.out.println(getClass().getSimpleName() + " " + answer);
    }
}
