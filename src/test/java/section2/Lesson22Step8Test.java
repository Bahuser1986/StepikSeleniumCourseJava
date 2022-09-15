package section2;

import base.BaseTest;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import java.io.File;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
/*
Lesson 2.2.8
1. Открыть страницу http://suninjuly.github.io/file_input.html
2. Заполнить текстовые поля: имя, фамилия, email
3. Загрузить файл. Файл должен иметь расширение .txt и может быть пустым
4. Нажать кнопку "Submit"
 */
public class Lesson22Step8Test extends BaseTest {
    @Test
    public void uploadFile() {
        Selenide.open("http://suninjuly.github.io/file_input.html");

        $(By.name("firstname")).sendKeys("Иван");
        $(By.name("lastname")).sendKeys("Иванов");
        $(By.name("email")).sendKeys("ivanov@gmail.com");
        $(By.name("file")).uploadFile(new File("src/test/java/base/text.txt"));
        $(By.cssSelector("[type='submit']")).click();

        Alert alert = switchTo().alert();
        String answer = alert.getText();

        Assertions.assertNotNull(answer, String.format("%s ответ к заданию не получен", getClass().getSimpleName()));
        System.out.println(getClass().getSimpleName() + " " + answer);
    }
}
