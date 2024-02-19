
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class SearchTests extends BasePage {
    @BeforeMethod
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        searchPage = new SearchPage(driver);

    }

    @Test
    public void searchProductTest() {
        homePage.clickOnMyAccountButton();
        loginPage.typeEmail("tom.muresan@yahoo.com");
        loginPage.typePassword("text123");
        loginPage.clickOnLoginButton();
        homePage.typeProductName("Palm Treo Pro");
        homePage.clickOnSearchButton();
        searchPage.isProductInList("Palm Treo Pro");

        String actualResults = driver.findElement(By.cssSelector("#entry_216816 > h1")).getText();
        Assert.assertTrue(actualResults.contains("Palm Treo Pro"));

    }

    @Test
    public void searchOtherProductTest() {
        homePage.typeProductName("iPod Nano");
        homePage.clickOnSearchButton();
        searchPage.isProductInList("IPod Nano");

        String actualResults = driver.findElement(By.cssSelector("#entry_216816 > h1")).getText();
        Assert.assertTrue(actualResults.contains("iPod Nano"));
    }
    @Test
    public void searchNotExistentProductTest() {
        homePage.typeProductName("table");
        homePage.clickOnSearchButton();

        String actualResults = driver.findElement(By.cssSelector("#entry_212469 > p")).getText();
        Assert.assertTrue(actualResults.contains("There is no product that matches the search criteria."));
    }
}
