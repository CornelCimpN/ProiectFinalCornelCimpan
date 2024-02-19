package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishlistPage extends BasePage {
    public WishlistPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy (css = "#content > div.table-responsive > table > tbody > tr > td.text-right.text-nowrap > a")
    private WebElement removeButton;

    public void clickOnCancelButton(){
        removeButton.click();
    }




}
