package section1;

import base.BaseTest;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
/*
Lesson 1.6.8
Ваши шаги:
В коде из шага 4 замените ссылку на  http://suninjuly.github.io/find_xpath_form.
Подберите уникальный XPath-селектор так, чтобы он находил только кнопку с текстом Submit.
XPath можете формулировать как угодно (по тексту, по структуре, по атрибутам) - главное, чтобы он работал.
Модифицируйте код из шага 3 таким образом, чтобы поиск кнопки происходил с помощью XPath.
Запустите ваш код.
 */
public class Lesson16Step8Test extends BaseTest {
    @Test
    public void clickRightButton() {
        Selenide.open("http://suninjuly.github.io/find_xpath_form");

        $(By.name("first_name")).sendKeys("Иван");
        $(By.name("last_name")).sendKeys("Иванов");
        $(By.className("city")).sendKeys("Москва");
        $(By.id("country")).sendKeys("Россия");
        $x("//button[@type='submit']").click();

        Alert alert = switchTo().alert();
        String answer = alert.getText();

        Assertions.assertNotNull(answer, String.format("%s ответ к заданию не получен", getClass().getSimpleName()));
        System.out.println(getClass().getSimpleName() + " " + answer);
    }
}
