package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;

import javax.swing.text.html.CSS;

public class NewsletterPage extends BasePage{
    public NewsletterPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver , this);
    }
    @FindBy(css = "#content > form > fieldset > div > div > div:nth-child(1) > label")
    private WebElement yesButton;
    @FindBy(css = "#content > form > div > div.float-right > input")
    private WebElement continueButton;
    @FindBy(css = "#content > form > fieldset > div > div > div:nth-child(2) > label")
    private WebElement noButton;


    public void clickOnYesButton(){
        yesButton.click();
    }
    public void clickOnContinueButton(){
        continueButton.click();
    }
    public void clickOnNoButton(){
        noButton.click();
    }
}
