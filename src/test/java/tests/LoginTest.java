package tests;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class LoginTest extends BaseTest {

    @Test
    public void signIn() {
        loginPage.open();
        loginPage.login("performance_glitch_user", "secret_sauce");
        boolean ProdBtnPresent = driver.findElement(By.xpath("//span[@ data-test='title']")).isDisplayed();
        assertTrue(ProdBtnPresent, "Ожидается плашка 'Products'");
    }

    @Test
    public void invalidSignIn() {
        loginPage.open();
        loginPage.login("performance_glitch_user", "secret_salt");
        assertEquals(loginPage.checkErrorMsg(), "Epic sadface: Username and password do not match any user in this service");
    }
}
