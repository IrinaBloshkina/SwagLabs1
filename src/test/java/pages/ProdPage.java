package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProdPage extends BasePage {
    private static final String ADD_TO_CART = "//*[text()='%s']//ancestor::div[@class='inventory_item']//child::button[text()='Add to cart']";
    private By counter = By.xpath("//span[@ data-test='shopping-cart-badge']");
    private By prodBtn = By.xpath("//span[@data-test='title']");

    public ProdPage(WebDriver driver) {
        super(driver);
    }

    public boolean getProdBtn() {
        return driver.findElement(prodBtn).isDisplayed();
    }

    public String getProdBtnText() {
        return driver.findElement(prodBtn).getText();
    }

    public void addToKart(final String goodsName) {
        By addToKart = By.xpath(ADD_TO_CART.formatted(goodsName ));
        driver.findElement(addToKart).click();
    }

    public String counter() {
        return driver.findElement(counter).getText();

    }
}
