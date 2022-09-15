package section1;

import base.BaseTest;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import java.util.List;
import static com.codeborne.selenide.Selenide.*;
/*
Lesson 1.6.7
нужно заполнить форму (http://suninjuly.github.io/huge_form.html). С помощью неё отдел маркетинга компании N
захотел собрать подробную информацию о пользователях своего продукта. В награду за заполнение формы становится
доступен код на скидку. Но маркетологи явно переусердствовали, добавив в форму 100 обязательных полей и
ограничив время на ее заполнение. Теперь эта задача под силу только роботам.
 */

public class Lesson16Step7Test extends BaseTest {
    @Test
    public void findElementsAndFill() {
        Selenide.open("http://suninjuly.github.io/huge_form.html");

        List<SelenideElement> formsList = $$(By.cssSelector("input[type='text']"));
        formsList.forEach(x->x.sendKeys("ответ"));
        $(By.cssSelector("[type='submit']")).click();

        Alert alert = switchTo().alert();
        String answer = alert.getText();

        Assertions.assertNotNull(answer, String.format("%s ответ к заданию не получен", getClass().getSimpleName()));
        System.out.println(getClass().getSimpleName() + " " + answer);
    }
}
