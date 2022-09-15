package section1;

import base.BaseTest;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
/*
Lesson 1.6.5
На указанной ниже странице вам нужно найти зашифрованную ссылку и кликнуть по ней:
1. Добавьте в код команду, которая откроет страницу: http://suninjuly.github.io/find_link_text
2. Добавьте команду, которая найдет ссылку с текстом. Текст ссылки, который нужно найти, зашифрован формулой:
str(math.ceil(math.pow(math.pi, math.e)*10000))
3. Добавьте команду для клика по найденной ссылке: она перенесет вас на форму регистрации
4. Заполните скриптом форму так же как вы делали в предыдущем шаге урока
После успешного заполнения вы получите код - отправьте его в качестве ответа на это задание
 */

public class Lesson16Step5Test extends BaseTest {
    @Test
    public void findLinkText() {
        Selenide.open("http://suninjuly.github.io/find_link_text");

        String code = String.valueOf((int)Math.ceil(Math.pow(Math.PI, Math.E) * 10000));
        $(By.linkText(code)).click();

        $(By.name("first_name")).sendKeys("Иван");
        $(By.name("last_name")).sendKeys("Иванов");
        $(By.className("city")).sendKeys("Москва");
        $(By.id("country")).sendKeys("Россия");
        $(By.cssSelector("[type='submit']")).click();

        String answer = switchTo().alert().getText();

        Assertions.assertNotNull(answer, String.format("%s ответ к заданию не получен", getClass().getSimpleName()));
        System.out.println(getClass().getSimpleName() + " " + answer);
    }
}
