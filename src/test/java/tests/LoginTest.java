package tests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import user.User;
import user.UserFactory;

import static org.testng.Assert.*;

public class LoginTest extends BaseTest {

    @Test (/*invocationCount = 4*/)
    public void signIn() {
        System.out.println("SignIn Tests are running in thread: "+Thread.currentThread().getId());
        loginPage.open();
        loginPage.login(UserFactory.withAdminPermission());
        assertTrue(prodPage.getProdBtn());
        assertEquals(prodPage.getProdBtnText(), "Products");
    }

   @DataProvider()
    public Object[][] invalidData(){
        return new Object[][]{
               /* {"performance_glitch_user", "secret_salt", "Epic sadface: Username and password do not match any user in this service"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"", "", "Epic sadface: Username is required"},*/
                {UserFactory.withLockedUserPermission(), "Epic sadface: Sorry, this user has been locked out."}};
    }

    @Test (dataProvider = "invalidData")
    public void invalidData(User user, String errMsg) {
        System.out.println("InvalidSignIn Tests are running in thread: "+Thread.currentThread().getId());
        loginPage.open();
        loginPage.login(user);
        assertEquals(loginPage.checkErrorMsg(), errMsg);
    }
}
