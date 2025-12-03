package tests;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.ITestContext;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import pages.*;
import utils.PropertyReader;
import utils.TestListener;

import java.time.Duration;

@Listeners({AllureTestNg.class, TestListener.class})
public class BaseTest {
    public WebDriver driver;
    LoginPage loginPage;
    ProdPage prodPage;
    CartPage cartPage;
    String user;
    String password;

    @Epic("Модуль логина интернет магазина")
    @Feature("Авторизация")
    @Step("Выполняем предварительную подготовку к загрузке")
    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser, ITestContext context) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start=maximized");
            options.addArguments("--guest");
            //options.addArguments("headless");
            driver = new ChromeDriver(options);
        }
        else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        context.setAttribute("driver", driver);
        loginPage = new LoginPage(driver);
        prodPage = new ProdPage(driver);
        cartPage = new CartPage(driver);

        user = PropertyReader.getProperty("swaglab.user");
        password = PropertyReader.getProperty("swaglab.password");
    }

    @Step("Закрытие браузера")
    @AfterMethod
    public void close() {
        driver.quit();
    }
}
