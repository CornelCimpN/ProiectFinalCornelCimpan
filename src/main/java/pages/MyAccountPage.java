package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class MyAccountPage extends BasePage {

    public MyAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#column-right > div > a:nth-child(5)")
    private WebElement WishListButton;
    @FindBy(css = "#column-right > div > a:nth-child(13)")
    private WebElement NewsletterButton;

    @FindBy(css = "#widget-navbar-217834 > ul > li:nth-child(6)")
    private WebElement myAccountButton;
    @FindBy(css = "#widget-navbar-217834 > ul > li:nth-child(6) > ul > li:nth-child(5) > a > div > span")
    private WebElement myVoucherButton;
    public void clickOnWishListButton(){
        WishListButton.click();
    }
    public void clickOnNewsletterButton(){
        NewsletterButton.click();
    }

    public void clickOnMyAccountButton(){
        myAccountButton.click();
    }
    public void clickOnMyVoucherButton(){
        myVoucherButton.click();
    }
}
