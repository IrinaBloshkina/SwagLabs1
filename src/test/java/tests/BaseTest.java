package tests;
import org.testng.annotations.Parameters;
import org.testng.annotations.Optional;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import utils.PropertyReader;
import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    LoginPage loginPage;
    ProdPage prodPage;
    CartPage cartPage;
    String user;
    String password;


    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {
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
        loginPage = new LoginPage(driver);
        prodPage = new ProdPage(driver);
        cartPage = new CartPage(driver);

        user = PropertyReader.getProperty("swaglab.user");
        password = PropertyReader.getProperty("swaglab.password");
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }
}
