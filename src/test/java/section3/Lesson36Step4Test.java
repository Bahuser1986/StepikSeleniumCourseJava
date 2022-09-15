package section3;

import base.BaseTest;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
/*
Lesson 3.6.4
1. открыть страницу
2. ввести правильный ответ (answer = math.log(int(time.time())))
3. нажать кнопку "Отправить"
4. дождаться фидбека о том, что ответ правильный
5. проверить, что текст в опциональном фидбеке полностью совпадает с "Correct!"
6. составить ответ на задание из actual results упавших тестов.
 */
public class Lesson36Step4Test extends BaseTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "https://stepik.org/lesson/236895/step/1",
            "https://stepik.org/lesson/236896/step/1",
            "https://stepik.org/lesson/236897/step/1",
            "https://stepik.org/lesson/236898/step/1",
            "https://stepik.org/lesson/236899/step/1",
            "https://stepik.org/lesson/236903/step/1",
            "https://stepik.org/lesson/236904/step/1",
            "https://stepik.org/lesson/236905/step/1"
            })
    public void collectErrors(String link) {
        Selenide.open(link);

        $x("//textarea[@placeholder='Напишите ваш ответ здесь...']")
                .should(Condition.visible, Duration.ofSeconds(10))
                .sendKeys(getValue());

        $(By.className("submit-submission")).should(Condition.visible).click();

        String answer = $(By.className("smart-hints__hint")).should(Condition.visible).getText();
        Assertions.assertEquals("Correct!", answer, "Собери ответ из Actual упавших тестов");
    }

    private String getValue() {
        return String.valueOf(Math.log((double)System.currentTimeMillis() / 1000));
    }

}
