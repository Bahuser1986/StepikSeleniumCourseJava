package section1;

import base.BaseTest;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
/*
Lesson 1.6.10
Вам дана страница с формой регистрации. Проверьте, что можно зарегистрироваться на сайте,
заполнив только обязательные поля, отмеченные символом *: First name, last name, email.
Текст для полей может быть любым. Успешность регистрации проверяется сравнением ожидаемого текста
"Congratulations! You have successfully registered!" с текстом на странице, которая открывается после регистрации.
 */
public class Lesson16Step10Test extends BaseTest {
    @Test
    public void checkSuccessfulRegistration() {
        Selenide.open("http://suninjuly.github.io/registration1.html");

        $x("//input[@placeholder='Input your first name']").sendKeys("Иван");
        $x("//input[@placeholder='Input your last name']").sendKeys("Иванов");
        $x("//input[@placeholder='Input your email']").sendKeys("ivanov@gmail.com");
        $x("//button[@type='submit']").click();

        SelenideElement messageElement = $(By.tagName("h1"));
        String message = messageElement.should(Condition.visible, Duration.ofSeconds(5)).getText();

        Assertions.assertEquals("Congratulations! You have successfully registered!", message);
    }
}
