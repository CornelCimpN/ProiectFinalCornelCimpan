
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class CheckoutTests extends BasePage {
    @BeforeMethod
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        searchPage = new SearchPage(driver);
        checkOutPage = new CheckoutPage(driver);
    }

    @Test
    public void validCheckOutTest() throws InterruptedException {
        homePage.typeProductName("iPod Nano");
        homePage.clickOnSearchButton();
        searchPage.isProductInList("IPod Nano");
        searchPage.clickOnBuyNowButton();
        Thread.sleep(4000);
        checkOutPage.typeFirstName("Radu");
        checkOutPage.typeLastName("Pop");
        checkOutPage.typeEmail("remusp9@gmail.com");
        checkOutPage.typeTelephoneNumber("0742356769");
        checkOutPage.typePassword("pop123");
        checkOutPage.typePasswordConfirm("pop123");
        checkOutPage.typeCompanyName("Ebay");
        checkOutPage.typeFirstAddress("Str.Brave");
        checkOutPage.typeLastAddress("Str.Brave.Nr.9");
        checkOutPage.typeCityName("Cluj");
        checkOutPage.typePostcode("342536");
        checkOutPage.clickOnCountryFieldRomania();
        Thread.sleep(2000);
        checkOutPage.clickOnRegionFieldCluj();
        Thread.sleep(4000);
        checkOutPage.clickOnPolicyButton();
        checkOutPage.clickOnTermsAndConditionsBox();
        checkOutPage.clickOnContinueButton();
        Thread.sleep(9000);
        checkOutPage.clickOnSaveOrderButton();
        Thread.sleep(2000);

        String actualResult = driver.findElement(By.cssSelector("#content > h1")).getText();
        Assert.assertTrue(actualResult.contains("Your order has been successfully processed!"));



    }
    @Test
    public void invalidCheckOutWithoutTermsAndConditionsTest() throws InterruptedException {
        homePage.typeProductName("iPod Nano");
        homePage.clickOnSearchButton();
        searchPage.isProductInList("IPod Nano");
        searchPage.clickOnBuyNowButton();
        Thread.sleep(4000);
        checkOutPage.typeFirstName("Radu");
        checkOutPage.typeLastName("Pop");
        checkOutPage.typeEmail("remusp9@gmail.com");
        checkOutPage.typeTelephoneNumber("0742356769");
        checkOutPage.typePassword("pop123");
        checkOutPage.typePasswordConfirm("pop123");
        checkOutPage.typeCompanyName("Ebay");
        checkOutPage.typeFirstAddress("Str.Brave");
        checkOutPage.typeLastAddress("Str.Brave.Nr.9");
        checkOutPage.typeCityName("Cluj");
        checkOutPage.typePostcode("342536");
        checkOutPage.clickOnCountryFieldRomania();
        Thread.sleep(2000);
        checkOutPage.clickOnRegionFieldCluj();
        Thread.sleep(2000);
        checkOutPage.clickOnPolicyButton();
        checkOutPage.clickOnContinueButton();
        Thread.sleep(2000);

        String actualResult = driver.findElement(By.cssSelector("#form-checkout > div.alert.alert-warning.alert-dismissible")).getText();
        Assert.assertTrue(actualResult.contains("Warning: You must agree to the Terms & Conditions!"));
    }
}
