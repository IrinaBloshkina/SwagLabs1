package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import user.User;

public class LoginPage extends BasePage {

    private final By userName = By.xpath("//*[@id='user-name']");
    private final By passw = By.xpath("//*[@id='password']");
    private final By loginBtn = By.xpath("//*[@id='login-button']");
    private final By errMsg = By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL);
    }

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

    private void pressLoginBtn() {
        driver.findElement(loginBtn).click();
    }

    public String checkErrorMsg() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errMsg));
        return driver.findElement(errMsg).getText();
    }
}
