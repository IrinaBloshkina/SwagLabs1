package tests;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ProdTest extends BaseTest {

    @Test(description = "Добавл. товара 'Sauce Labs Backpack' в корзину")
    public void check1GoodsAdded() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        prodPage.addToKart("Sauce Labs Backpack");
        assertEquals(prodPage.counter(), "1");
    }

    @Test(description = "Добавл. товара 'Sauce Labs Bike Light' в корзину")
    public void check2GoodsAdded() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        prodPage.addToKart("Sauce Labs Bike Light");
    }

    @Test(description = "Проверка счетчика товаров корзины")
    public void checkCounter() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        prodPage.addToKart("Sauce Labs Bike Light");
        prodPage.addToKart("Sauce Labs Backpack");
        assertEquals(prodPage.counter(),"2");
    }
}