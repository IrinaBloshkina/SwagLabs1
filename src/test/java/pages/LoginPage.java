package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    private By userName = By.xpath("//*[@id='user-name']");
    private By passw = By.xpath("//*[@id='password']");
    private By loginBtn = By.xpath("//*[@id='login-button']");
    private By errMsg = By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public void login(String loginName, String password) {
        driver.findElement(userName).sendKeys(loginName);
        driver.findElement(passw).sendKeys(password);
        driver.findElement(loginBtn).click();
    }

    public String checkErrorMsg() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errMsg));
        return driver.findElement(errMsg).getText();
    }
}
