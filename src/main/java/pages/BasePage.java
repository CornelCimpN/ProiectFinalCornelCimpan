package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BasePage {

    public static WebDriver driver;
    private String BASE_URL = "https://ecommerce-playground.lambdatest.io";

    //define all pages
    public HomePage homePage;
    public LoginPage loginPage;
    public RegisterPage registerPage;
    public ForgottenPasswordPage forgottenPasswordPage;
    public SearchPage searchPage;
    public MyAccountPage myAccountPage;
    public WishlistPage wishListPage;
    public NewsletterPage newsletterPage;
    public AddressBookPage addressBookPage;
    public CheckoutPage checkOutPage;
    public BasePage() {
// Default constructor
    }

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
    }

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }


    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


}




