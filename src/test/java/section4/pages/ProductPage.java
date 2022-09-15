package section4.pages;

import base.BasePage;
import base.BaseTest;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class ProductPage extends BasePage {
    private final SelenideElement cartButton = $(By.className("btn-add-to-basket"));
    private final SelenideElement productName = $x("//div[contains(@class, 'product_main')]/h1");
    private final SelenideElement actualProductName = $(By.cssSelector(".alert-success:nth-child(1) strong"));
    private final SelenideElement addedToCartMessage = $(By.cssSelector(".alert-success:nth-child(1)>div"));
    private static final SelenideElement price = $(By.cssSelector(".product_main>.price_color"));
    private final SelenideElement cartPrice = $(By.cssSelector(".alert-info>div strong"));
    public ProductPage(String url) {
        Selenide.open(url);
    }
    public void clickOnAddToCart() {
        cartButton.click();
    }
    public void solveQuiz() {
        Alert alert = switchTo().alert();
        int x = Integer.parseInt(alert.getText().split(" ")[2]);
        alert.sendKeys(BaseTest.getValue(x));
        alert.accept();
    }
    public String getCode() {
        return switchTo().alert().getText();
    }
    public SelenideElement getProductName() {
        return productName;
    }
    public SelenideElement getActualProductName() {
        return actualProductName;
    }
    public SelenideElement getAddedToCartMessage() {
        return addedToCartMessage;
    }
    public SelenideElement getPrice() {
        return price;
    }
    public SelenideElement getCartPrice() {
        return cartPrice;
    }
}
