
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class NewsletterTests extends BasePage {
    @BeforeMethod
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        myAccountPage = new MyAccountPage(driver);
        newsletterPage = new NewsletterPage(driver);
    }
    @Test
    public void newsletterTestSubscriptionButton(){
        homePage.clickOnMyAccountButton();
        loginPage.typeEmail("tom.muresan@yahoo.com");
        loginPage.typePassword("text123");
        loginPage.clickOnLoginButton();
        myAccountPage.clickOnNewsletterButton();
        newsletterPage.clickOnYesButton();
        newsletterPage.clickOnContinueButton();

        String actualResult = driver.findElement(By.cssSelector("#account-account > div.alert.alert-success.alert-dismissible")).getText();
        Assert.assertTrue(actualResult.contains("Success: Your newsletter subscription has been successfully updated!"));
    }
    @Test
    public void newsletterTestNoSubscriptionButton()    {
        homePage.clickOnMyAccountButton();
        loginPage.typeEmail("tom.muresan@yahoo.com");
        loginPage.typePassword("text123");
        loginPage.clickOnLoginButton();
        myAccountPage.clickOnNewsletterButton();
        newsletterPage.clickOnNoButton();
        newsletterPage.clickOnContinueButton();

        String actualResult = driver.findElement(By.cssSelector("#account-account > div.alert.alert-success.alert-dismissible")).getText();
        Assert.assertTrue(actualResult.contains("Success: Your newsletter subscription has been successfully updated!"));
    }




}
