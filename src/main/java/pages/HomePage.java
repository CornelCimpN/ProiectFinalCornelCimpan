package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#widget-navbar-217834 > ul > li:nth-child(6)")
    private WebElement myAccountButton;
    @FindBy(css = "#search > div.search-input-group.flex-fill > div.search-input.d-flex > div.flex-fill > input[type=text]")
    private WebElement searchField;
    @FindBy(css = "#search > .search-button .type-text")
    private WebElement searchButton;
    public void clickOnMyAccountButton() {
        myAccountButton.click();
    }
    public void typeProductName(String productName){
        searchField.sendKeys(productName);
    }
    public void  clickOnSearchButton(){
        searchButton.click();
    }

}
