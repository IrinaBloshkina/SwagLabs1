package pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProdPage extends BasePage {
    private static final String ADD_TO_CART = "//*[text()='%s']//ancestor::div[@class='inventory_item']//child::button[text()='Add to cart']";
    private final By counter = By.xpath("//span[@ data-test='shopping-cart-badge']");
    private final By prodBtn = By.xpath("//span[@data-test='title']");

        public ProdPage(WebDriver driver) {
        super(driver);
    }

    @Step("Ожидаем прогрузки страницы с товарами")
    public boolean getProdBtn() {
        return driver.findElement(prodBtn).isDisplayed();
    }

    @Step("Проверяем название страницы")
    public String getProdBtnText() {
        return driver.findElement(prodBtn).getText();
    }

    @Step("Добавляем товар в корзину")
    public void addToKart(final String goodsName) {
        By addToKart = By.xpath(ADD_TO_CART.formatted(goodsName ));
        driver.findElement(addToKart).click();
    }

    @Step("Проверяем счетчик товаров в корзине")
    public String counter() {
        return driver.findElement(counter).getText();
    }
}
