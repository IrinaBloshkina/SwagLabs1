package pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {
    private By prodBtn = By.xpath("//span[@ data-test='title']");
    List<WebElement> allProducts = driver.findElements(By.cssSelector("inventory_item_name"));

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Получаем список товаров на странице")
    public ArrayList<String> getProdNames() {
        ArrayList<String> names = new ArrayList<>();
        for (WebElement product : allProducts) {
            names.add(product.getText());
        }
        return names;
    }

    @Step("Ожидаем прогрузки элемента Products")
    public void waitPageLoaded() {
        driver.findElement(prodBtn).isDisplayed();
    }
}
