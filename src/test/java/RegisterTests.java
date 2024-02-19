
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

public class RegisterTests extends BasePage {
    @BeforeMethod
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);

    }

    @Test
    public void validRegisterTest()  {
        homePage.clickOnMyAccountButton();
        registerPage.clickOnRegisterButton();
        registerPage.typeFirstName("Tim");
        registerPage.typeLastName("Pop");
        registerPage.typeEmail("raduuupopp@yahoo.com"); //cont nou pentru validare
        registerPage.typeTelephoneNumber("0754655679");
        registerPage.typePassword("tim1234");
        registerPage.typePasswordConfirm("tim1234");
        registerPage.clickOnPrivatePolicyBox();
        registerPage.clickOnContinueButton();

        String actualResult = driver.findElement(By.cssSelector("#content > h1")).getText();
        Assert.assertTrue(actualResult.contains("Your Account Has Been Created!"));
    }
    @Test
    public void invalidAlreadyRegisterTest(){
        homePage.clickOnMyAccountButton();
        registerPage.clickOnRegisterButton();
        registerPage.typeFirstName("Tim");
        registerPage.typeLastName("Pop");
        registerPage.typeEmail("timpop@yahoo.com");
        registerPage.typeTelephoneNumber("0754655679");
        registerPage.typePassword("tim1234");
        registerPage.typePasswordConfirm("tim1234");
        registerPage.clickOnPrivatePolicyBox();
        registerPage.clickOnContinueButton();

        String actualResult = driver.findElement(By.cssSelector("#account-register > .alert-dismissible")).getText();
        Assert.assertTrue(actualResult.contains("Warning: E-Mail Address is already registered!"));
    }
    @Test
    public void incompleteRegisterTestWithoutFirstName(){
        homePage.clickOnMyAccountButton();
        registerPage.clickOnRegisterButton();
        registerPage.typeLastName("Pop");
        registerPage.typeEmail("timpop@yahoo.com");
        registerPage.typeTelephoneNumber("0754655679");
        registerPage.typePassword("tim1234");
        registerPage.typePasswordConfirm("tim1234");
        registerPage.clickOnPrivatePolicyBox();
        registerPage.clickOnContinueButton();

        String actualResult = driver.findElement(By.cssSelector("#account > div:nth-child(3) ")).getText();
        Assert.assertTrue(actualResult.contains("First Name must be between 1 and 32 characters!"));
    }
    @Test
    public void incompleteRegisterTestWithoutConfirmPassword(){
        homePage.clickOnMyAccountButton();
        registerPage.clickOnRegisterButton();
        registerPage.typeFirstName("Tim");
        registerPage.typeLastName("Pop");
        registerPage.typeEmail("timpop@yahoo.com");
        registerPage.typeTelephoneNumber("0754655679");
        registerPage.typePassword("tim1234");
        registerPage.clickOnPrivatePolicyBox();
        registerPage.clickOnContinueButton();

        String actualResult = driver.findElement(By.cssSelector("#content > form > fieldset:nth-child(2) > div:nth-child(3) > div > div")).getText();
        Assert.assertTrue(actualResult.contains("Password confirmation does not match password!"));
    }

    @Test
    public void registerTestWithSubscribeButton(){
        homePage.clickOnMyAccountButton();
        registerPage.clickOnRegisterButton();
        registerPage.typeFirstName("Tim");
        registerPage.typeLastName("Pop");
        registerPage.typeEmail("timpop10@yahoo.com");
        registerPage.typeTelephoneNumber("0754655679");
        registerPage.typePassword("tim1234");
        registerPage.typePasswordConfirm("tim1234");
        registerPage.clickOnYesBox();
        registerPage.clickOnPrivatePolicyBox();
        registerPage.clickOnContinueButton();

        String actualResult = driver.findElement(By.cssSelector("#content > h1")).getText();
        Assert.assertTrue(actualResult.contains("Your Account Has Been Created!"));
    }
    @Test
    public void registerTestWithoutButtonPrivacyPolicy() {
        homePage.clickOnMyAccountButton();
        registerPage.clickOnRegisterButton();
        registerPage.typeFirstName("Tim");
        registerPage.typeLastName("Pop");
        registerPage.typeEmail("timpop10@yahoo.com");
        registerPage.typeTelephoneNumber("0754655679");
        registerPage.typePassword("tim1234");
        registerPage.typePasswordConfirm("tim1234");
        registerPage.clickOnContinueButton();

        String actualResult = driver.findElement(By.cssSelector("#account-register > div.alert.alert-danger.alert-dismissible")).getText();
        Assert.assertTrue(actualResult.contains("Warning: You must agree to the Privacy Policy!"));
    }
    @Test
    public void incompleteRegisterTestWithoutNumberTelephone () {
        homePage.clickOnMyAccountButton();
        registerPage.clickOnRegisterButton();
        registerPage.typeFirstName("Tim");
        registerPage.typeLastName("Pop");
        registerPage.typeEmail("timpop@yahoo.com");
        registerPage.typePassword("tim1234");
        registerPage.typePasswordConfirm("tim1234");
        registerPage.clickOnPrivatePolicyBox();
        registerPage.clickOnContinueButton();

        String actualResult = driver.findElement(By.cssSelector("#account > div:nth-child(6) > div > div")).getText();
        Assert.assertTrue(actualResult.contains("Telephone must be between 3 and 32 characters!"));
    }

    @Test
    public void incompleteRegisterTestWithoutEmail(){

        homePage.clickOnMyAccountButton();
        registerPage.clickOnRegisterButton();
        registerPage.typeFirstName("Tim");
        registerPage.typeLastName("Pop");
        registerPage.typeTelephoneNumber("0754655679");
        registerPage.typePassword("tim1234");
        registerPage.typePasswordConfirm("tim1234");
        registerPage.clickOnPrivatePolicyBox();
        registerPage.clickOnContinueButton();

        String actualResult = driver.findElement(By.cssSelector("#account > div:nth-child(5) > div > div")).getText();
        Assert.assertTrue(actualResult.contains("E-Mail Address does not appear to be valid!"));



    }

}