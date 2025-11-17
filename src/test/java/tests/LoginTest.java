package tests;
import org.testng.annotations.DataProvider;
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

    @DataProvider()
    public Object[][] invalidData(){
        return new Object[][]{
                {"performance_glitch_user", "secret_salt", "Epic sadface: Username and password do not match any user in this service"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"", "", "Epic sadface: Username is required"},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."}
        };
    }

    @Test (dataProvider = "invalidData")
    public void invalidSignIn(String loginName, String password, String errMsg) {
        loginPage.open();
        loginPage.login(loginName,password);
        assertEquals(loginPage.checkErrorMsg(), errMsg);
    }
}
