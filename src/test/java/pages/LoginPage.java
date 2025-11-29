package pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import user.User;

public class LoginPage extends BasePage {
    private final By userName = By.xpath("//*[@id='user-name']");
    private final By passw = By.xpath("//*[@id='password']");
    private final By loginBtn = By.xpath("//*[@id='login-button']");
    private final By errMsg = By.xpath("//*[@data-test ='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Загружаем страницу")
    public void open() {
        driver.get(BASE_URL);
    }

    @Step("Логинимся под кредами: логин = {user.email}, пароль = *******")
    public void login(User user )  {
        fillInLogin(user.getEmail());
        fillPassword(user.getPassword());
        pressLoginBtn();
    }

    private void fillInLogin(String loginName) {
        driver.findElement(userName).sendKeys(loginName);
    }

    private void fillPassword(String password) {
        driver.findElement(passw).sendKeys(password);
    }

    @Step("Кликаем 'Login'")
    private void pressLoginBtn() {
        driver.findElement(loginBtn).click();
    }

    @Step("Проверяем содержание сообщения об ошибке")
    public String checkErrorMsg() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errMsg));
        return driver.findElement(errMsg).getText();
    }
}
