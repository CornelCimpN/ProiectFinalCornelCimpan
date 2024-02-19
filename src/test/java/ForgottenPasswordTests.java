import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import pages.ForgottenPasswordPage;

public class ForgottenPasswordTests extends BasePage {

    @BeforeMethod
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        forgottenPasswordPage = new ForgottenPasswordPage(driver);
    }

    @Test
    public void validForgottenPasswordTest(){
        homePage.clickOnMyAccountButton();
        loginPage.clickOnForgottenPasswordButton();
        forgottenPasswordPage.typeEmail("johnpop@yahoo.com");
        forgottenPasswordPage.clickOnContinueButton();

        String actualResult = driver.findElement(By.cssSelector("#account-login > div.alert.alert-success.alert-dismissible")).getText();
        Assert.assertTrue(actualResult.contains("An email with a confirmation link has been sent your email address"));
    }
    @Test
    public void forgottenPasswordTestWithInvalidEmail(){
        homePage.clickOnMyAccountButton();
        loginPage.clickOnForgottenPasswordButton();
        forgottenPasswordPage.typeEmail("eliaspop@yahoo.com");
        forgottenPasswordPage.clickOnContinueButton();

        String actualResult = driver.findElement(By.cssSelector("#account-forgotten > div.alert.alert-danger.alert-dismissible")).getText();
        Assert.assertTrue(actualResult.contains("Warning: The E-Mail Address was not found in our records, please try again!"));
    }
    @Test
    public void forgottenPasswordTestWithEmptyEmailField(){
        homePage.clickOnMyAccountButton();
        loginPage.clickOnForgottenPasswordButton();
        forgottenPasswordPage.clickOnContinueButton();


        String actualResult = driver.findElement(By.cssSelector("#account-forgotten > div.alert.alert-danger.alert-dismissible")).getText();
        Assert.assertTrue(actualResult.contains("Warning: The E-Mail Address was not found in our records, please try again!"));
    }

}







