package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogPage {
    WebDriver driver;

    private By userName = By.xpath("//*[@id=\"user-name\"]");
    private By passw = By.xpath("//*[@id=\"password\"]");
    private By logBtn = By.xpath("//*[@id=\"login-button\"]");
    private By errMsg = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");

    public LogPage(WebDriver driver) {
        this.driver = driver;
        //this.wait = wait;
    }

    public void open() {
        driver.get("https://www.saucedemo.com/");
    }

    public void login(String logName, String password) {
        driver.findElement(userName).sendKeys(logName);
        driver.findElement(passw).sendKeys(password);
        driver.findElement(logBtn).click();

    }

    public String checkErrorMsg() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(errMsg));
        return driver.findElement(errMsg).getText();
    }
}
