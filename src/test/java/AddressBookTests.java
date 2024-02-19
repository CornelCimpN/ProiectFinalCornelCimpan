
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class AddressBookTests extends BasePage {

    @BeforeMethod
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        addressBookPage = new AddressBookPage(driver);
        registerPage = new RegisterPage(driver);
    }

    @Test
    public void validNewAddressTest() throws InterruptedException {
        homePage.clickOnMyAccountButton();
        loginPage.typeEmail("tom.muresan@yahoo.com");
        loginPage.typePassword("text123");
        loginPage.clickOnLoginButton();
        addressBookPage.clickOnAddressBookButton();
        addressBookPage.clickOnNewAddressButton();
        addressBookPage.typeFirstName("Clay");
        addressBookPage.typeLastName("Macos");
        addressBookPage.typeCompanyName("Google");
        addressBookPage.typeFirstAddress("Str.Brave");
        addressBookPage.typeLastAddress("Str.Brave.Nr.9");
        addressBookPage.typeCityName("Cluj-Napoca");
        addressBookPage.typePostcode("342577");
        addressBookPage.clickOnCountryFieldRomania();
        Thread.sleep(1000);
        addressBookPage.clickOnRegionFieldCluj();
        addressBookPage.clickOnContinueButton();

        String actualResult = driver.findElement(By.cssSelector("#account-address > div.alert.alert-success.alert-dismissible")).getText();
        Assert.assertTrue(actualResult.contains("Your address has been successfully added"));
    }

    @Test
    public void removeAddressBook() {
        homePage.clickOnMyAccountButton();
        loginPage.typeEmail("tom.muresan@yahoo.com");
        loginPage.typePassword("text123");
        loginPage.clickOnLoginButton();
        addressBookPage.clickOnAddressBookButton();
        addressBookPage.clickOnDeleteButton();

        String actualResult = driver.findElement(By.cssSelector("#account-address > div.alert.alert-success.alert-dismissible")).getText();
        Assert.assertTrue(actualResult.contains("Your address has been successfully deleted"));
    }

    @Test
    public void editAddressBook() {
        homePage.clickOnMyAccountButton();
        loginPage.typeEmail("tom.muresan@yahoo.com");
        loginPage.typePassword("text123");
        loginPage.clickOnLoginButton();
        addressBookPage.clickOnAddressBookButton();
        addressBookPage.clickOnEditButton();
        addressBookPage.typePostcode("342577");
        addressBookPage.clickOnContinueButton();

        String actualResult = driver.findElement(By.cssSelector("#account-address > div.alert.alert-success.alert-dismissible")).getText();
        Assert.assertTrue(actualResult.contains("Your address has been successfully updated"));
    }

    @Test
    public void AddressBookTestWithoutFirstName() {
        homePage.clickOnMyAccountButton();
        loginPage.typeEmail("tom.muresan@yahoo.com");
        loginPage.typePassword("text123");
        loginPage.clickOnLoginButton();
        addressBookPage.clickOnAddressBookButton();
        addressBookPage.clickOnNewAddressButton();
        addressBookPage.typeLastName("Macos");
        addressBookPage.typeCompanyName("Google");
        addressBookPage.typeFirstAddress("Str.Brave");
        addressBookPage.typeLastAddress("Str.Brave.Nr.9");
        addressBookPage.typeCityName("Cluj-Napoca");
        addressBookPage.typePostcode("342577");
        addressBookPage.clickOnCountryFieldRomania();
        addressBookPage.clickOnRegionFieldCluj();
        addressBookPage.clickOnContinueButton();

        String actualResult = driver.findElement(By.cssSelector("#content > form > fieldset > div:nth-child(1) > div > div")).getText();
        Assert.assertTrue(actualResult.contains("First Name must be between 1 and 32 characters!"));
    }

    @Test
    public void AddressBookTestWithoutFirstAddress() {
        homePage.clickOnMyAccountButton();
        loginPage.typeEmail("tom.muresan@yahoo.com");
        loginPage.typePassword("text123");
        loginPage.clickOnLoginButton();
        addressBookPage.clickOnAddressBookButton();
        addressBookPage.clickOnNewAddressButton();
        addressBookPage.typeFirstName("Clay");
        addressBookPage.typeLastName("Macos");
        addressBookPage.typeCompanyName("Google");
        addressBookPage.typeLastAddress("Str.Brave.Nr.9");
        addressBookPage.typeCityName("Cluj-Napoca");
        addressBookPage.typePostcode("342577");
        addressBookPage.clickOnCountryFieldRomania();
        addressBookPage.clickOnRegionFieldCluj();
        addressBookPage.clickOnContinueButton();

        String actualResult = driver.findElement(By.cssSelector("#content > form > fieldset > div:nth-child(4) > div > div")).getText();
        Assert.assertTrue(actualResult.contains("Address must be between 3 and 128 characters!"));
    }

    @Test
    public void NewAddressTestWithoutCity() {
        homePage.clickOnMyAccountButton();
        loginPage.typeEmail("tom.muresan@yahoo.com");
        loginPage.typePassword("text123");
        loginPage.clickOnLoginButton();
        addressBookPage.clickOnAddressBookButton();
        addressBookPage.clickOnNewAddressButton();
        addressBookPage.typeFirstName("Clay");
        addressBookPage.typeLastName("Macos");
        addressBookPage.typeCompanyName("Google");
        addressBookPage.typeFirstAddress("Str.Brave");
        addressBookPage.typeLastAddress("Str.Brave.Nr.9");
        addressBookPage.typePostcode("342577");
        addressBookPage.clickOnCountryFieldRomania();
        addressBookPage.clickOnRegionFieldCluj();
        addressBookPage.clickOnContinueButton();

        String actualResult = driver.findElement(By.cssSelector("#content > form > fieldset > div:nth-child(6) > div > div")).getText();
        Assert.assertTrue(actualResult.contains("City must be between 2 and 128 characters!"));
    }
}