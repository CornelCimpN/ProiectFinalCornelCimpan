package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class ForgottenPasswordPage extends BasePage {

    public ForgottenPasswordPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "input-email")
    private WebElement emailField;
    @FindBy(css ="#content > form > div > div.float-right > button" )
    private WebElement continueButton;


    public void typeEmail(String emailAddress){
        emailField.sendKeys(emailAddress);
    }
    public void clickOnContinueButton(){
        continueButton.click();

    }






}
