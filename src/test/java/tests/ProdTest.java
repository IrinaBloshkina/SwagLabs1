package tests;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import user.UserFactory;
import static org.testng.Assert.*;

public class ProdTest extends BaseTest {
    final String product1 = "Sauce Labs Backpack";
    final String product2 = "Sauce Labs Bike Light";

    @Epic("Модуль каталога интернет магазина")
    @Feature("Страница каталога товаров")
    @Story("Добавление товара в корзину")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Irina Bloshkina @kakoy to vnutrenniy chat ")
    @TmsLink("SwagLabs1/tree/Branch-3")
    @Issue ("skypro_final_task")
    @Test(description = "Добавл. товара 'Sauce Labs Backpack' в корзину")
    public void check1GoodsAdded() {
        System.out.println("Check1GoodsAdded Tests are running in thread: "+Thread.currentThread().getId());
        loginPage.open();
        loginPage.login(UserFactory.withAdminPermission());
        prodPage.addToKart(product1);
        assertEquals(prodPage.counter(), "1");
    }

    @Epic("Модуль каталога интернет магазина")
    @Feature("Страница каталога товаров")
    @Story("Добавление товаров в корзину")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Irina Bloshkina @kakoy to vnutrenniy chat ")
    @TmsLink("SwagLabs1/tree/Branch-3")
    @Issue ("skypro_final_task")
    @Test(description = "Добавл. товара 'Sauce Labs Bike Light' в корзину")
    public void check2GoodsAdded() {
        loginPage.open();
        loginPage.login(UserFactory.withAdminPermission());
        prodPage.addToKart(product2);
    }

    @Epic("Модуль каталога интернет магазина")
    @Feature("Страница каталога товаров")
    @Story("Добавление товаров в корзину и проверка счётчика товаров")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Irina Bloshkina @kakoy to vnutrenniy chat ")
    @TmsLink("SwagLabs1/tree/Branch-3")
    @Issue ("skypro_final_task")
    @Test(description = "Проверка счетчика товаров корзины")
    public void checkCounter() {
        loginPage.open();
        loginPage.login(UserFactory.withAdminPermission());
        prodPage.addToKart(product2);
        prodPage.addToKart(product1);
        assertEquals(prodPage.counter(),"2");
        assertFalse(cartPage.getProdNames().contains(product2));
    }
}
