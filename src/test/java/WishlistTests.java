
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class WishlistTests extends BasePage {
    @BeforeMethod
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        searchPage = new SearchPage(driver);
        myAccountPage = new MyAccountPage(driver);
        wishListPage = new WishlistPage(driver);
    }
    @Test
    public void addProductToWishListTest() throws InterruptedException {
        homePage.clickOnMyAccountButton();
        loginPage.typeEmail("tom.muresan@yahoo.com");
        loginPage.typePassword("text123");
        loginPage.clickOnLoginButton();
        homePage.typeProductName("Imac");
        homePage.clickOnSearchButton();
        searchPage.clickOnProductButton();
        searchPage.clickOnWishListButton();
        Thread.sleep(1000);

        String actualResult = driver.findElement(By.cssSelector("#notification-box-top > div > div.toast-body > div > p")).getText();
        Assert.assertTrue(actualResult.contains("Success: You have added"));
    }
    @Test
    public void removeProductToWishListTest() {
        homePage.clickOnMyAccountButton();
        loginPage.typeEmail("tom.muresan@yahoo.com");
        loginPage.typePassword("text123");
        loginPage.clickOnLoginButton();
        myAccountPage.clickOnWishListButton();
        wishListPage.clickOnCancelButton();

        String actualResult = driver.findElement(By.cssSelector("#account-wishlist > div.alert.alert-success.alert-dismissible")).getText();
        Assert.assertTrue(actualResult.contains("Success: You have modified your wish list!"));
    }


}
