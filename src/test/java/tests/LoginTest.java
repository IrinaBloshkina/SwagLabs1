package tests;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class LoginTest extends BaseTest {

    @Test (description = "Авториз с валидными данными")
    public void signIn() {
        loginPage.open();
        loginPage.login("performance_glitch_user", "secret_sauce");
        assertTrue(prodPage.getProdBtn());
        assertEquals(prodPage.getProdBtnText(), "Products");
    }

    @Test (description = "Авториз с невалидным паролем")
    public void invalidSignIn() {
        loginPage.open();
        loginPage.login("performance_glitch_user", "secret_salt");
        assertEquals(loginPage.checkErrorMsg(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test (description = "Авториз с пустым полем password")
    public void emptyPassword() {
        loginPage.open();
        loginPage.login("standard_user", "");
        assertEquals(loginPage.checkErrorMsg(), "Epic sadface: Password is required");
    }

    @Test (description = "Авториз с пустым полем user")
    public void emptyUsername() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        assertEquals(loginPage.checkErrorMsg(), "Epic sadface: Username is required");
    }

    @Test (description = "Авториз с пустыми полями")
    public void emptyAll() {
        loginPage.open();
        loginPage.login("", "");
        assertEquals(loginPage.checkErrorMsg(), "Epic sadface: Username is required");
    }

    @Test (description = "Авториз заблокир пользователя")
    public void lockedUser() {
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");
        assertEquals(loginPage.checkErrorMsg(), "Epic sadface: Sorry, this user has been locked out.");
    }
}
