package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage extends BasePage {
    public SearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy (css = "#entry_212469 > div > div:nth-child(1) > div > div.caption > h4 > a")
    private WebElement productButton;
    @FindBy(css = "#image-gallery-216811 > div.image-thumb.d-flex > button")
    private WebElement wishListButton;
    @FindBy(css = ".text-ellipsis-2")
    private List<WebElement> listOfProductNames;
    @FindBy(css = "#entry_216843 > button")
    private WebElement buyNowButton;
    public void clickOnProductButton(){
        productButton.click();
    }
    public void clickOnWishListButton(){
        wishListButton.click();
    }
    public boolean isProductInList(String productName) {
        for (WebElement element : listOfProductNames) {
            if (element.getText().equalsIgnoreCase(productName)) {
                element.click();
                return true;
            }
        }
        return false;
    }
    public void clickOnBuyNowButton(){
        buyNowButton.click();
    }


}
