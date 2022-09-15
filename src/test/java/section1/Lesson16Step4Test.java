package section1;

import base.BaseTest;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import static com.codeborne.selenide.Selenide.*;
/*
Lesson 1.6.4
Вам нужно открыть страницу по ссылке и заполнить форму на этой странице с помощью Selenium.
Если всё сделано правильно, то вы увидите окно с проверочным кодом.
Это число вам нужно ввести в качестве ответа в этой задаче.
 */
public class Lesson16Step4Test extends BaseTest {
    @Test
    public void fillFormsAndSubmit() {
        SelenideElement firstNameElement = $x("//input[@name='first_name']");
        SelenideElement lastNameElement = $x("//input[@name='last_name']");
        SelenideElement cityElement = $x("//input[contains(@class, 'city')]");
        SelenideElement countryElement = $x("//input[@id='country']");
        SelenideElement submitButton = $x("//button[@id='submit_button']");

        Selenide.open("http://suninjuly.github.io/simple_form_find_task.html");

        firstNameElement.sendKeys("Иван");
        lastNameElement.sendKeys("Иванов");
        cityElement.sendKeys("Москва");
        countryElement.sendKeys("Россия");
        submitButton.click();

        Alert alert = switchTo().alert();
        String answer = alert.getText();

        Assertions.assertNotNull(answer, String.format("%s ответ к заданию не получен", getClass().getSimpleName()));
        System.out.println(getClass().getSimpleName() + " " + answer);
    }
}
