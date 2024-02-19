
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BasePage {
    @BeforeMethod
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }


    @Test
    public void validLoginTest() {
        homePage.clickOnMyAccountButton();
        loginPage.typeEmail("tom.muresan@yahoo.com");
        loginPage.typePassword("text123");
        loginPage.clickOnLoginButton();

        String actualResult = driver.findElement(By.cssSelector("#content > div:nth-child(1) > h2")).getText();
        Assert.assertTrue(actualResult.contains("My Account"));


    }

    @Test
    public void invalidLoginTest() {
        homePage.clickOnMyAccountButton();
        loginPage.typeEmail("tomm.muresan@yahoo.com");
        loginPage.typePassword("text123");
        loginPage.clickOnLoginButton();

        String actualResult = driver.findElement(By.cssSelector("#account-login > div.alert.alert-danger.alert-dismissible")).getText();
        Assert.assertTrue(actualResult.contains("Warning: No match for E-Mail Address and/or Password."));


    }

    @Test
    public void invalidLoginTestWithEmptyFields() {
        homePage.clickOnMyAccountButton();
        loginPage.clickOnLoginButton();

        String actualResult = driver.findElement(By.cssSelector("#account-login > div.alert.alert-danger.alert-dismissible")).getText();
        Assert.assertTrue(actualResult.contains("Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour."));
    }

    @Test
    public void invalidLoginTestWithEmptyEmailField() {
        homePage.clickOnMyAccountButton();
        loginPage.typePassword("text123");
        loginPage.clickOnLoginButton();

        String actualResult = driver.findElement(By.cssSelector("#account-login > div.alert.alert-danger.alert-dismissible")).getText();
        Assert.assertTrue(actualResult.contains("Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour."));
    }

    @Test
    public void invalidLoginTestWithEmptyPasswordField() throws InterruptedException {
        homePage.clickOnMyAccountButton();
        loginPage.typeEmail("tomm.muresan@yahoo.com");
        loginPage.clickOnLoginButton();
        Thread.sleep(4000);

        String actualResult = driver.findElement(By.cssSelector("#account-login > div.alert.alert-danger.alert-dismissible")).getText();
        Assert.assertTrue(actualResult.contains("Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour."));

    }
}