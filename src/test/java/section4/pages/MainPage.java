package section4.pages;

import base.BasePage;
import com.codeborne.selenide.Selenide;

public class MainPage extends BasePage {
    public static final String URL = "http://selenium1py.pythonanywhere.com";
    public MainPage() {
        Selenide.open(URL);
    }
}
