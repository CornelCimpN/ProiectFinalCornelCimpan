package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BasePage{

    public RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#column-right > div > a:nth-child(2)")
    private WebElement registerButton;
    @FindBy(id = "input-firstname")
    private WebElement firstNameField;
    @FindBy(id = "input-lastname")
    private WebElement lastNameField;
    @FindBy(id = "input-email")
    private WebElement emailField;
    @FindBy(id = "input-telephone")
    private WebElement telephoneField;
    @FindBy(id = "input-password")
    private WebElement passwordField;
    @FindBy(id = "input-confirm")
    private WebElement passwordConfirmField;
    @FindBy(css = "#content > form > div > div > div > label")
    private WebElement privatePolicyCheckBox;
    @FindBy(css = "#content > form > div > div > input")
    private WebElement continueButton;
    @FindBy(css = "#content > form > fieldset:nth-child(3) > div > div > div:nth-child(1) > label")
    private WebElement yesSubscribeBox;

    public void clickOnRegisterButton(){
        registerButton.click();
    }

    public void typeFirstName(String firstNameText){
        firstNameField.sendKeys(firstNameText);
    }
    public void typeLastName(String lastNameText){
        lastNameField.sendKeys(lastNameText);
    }
    public void typeEmail(String emailAddress){
        emailField.sendKeys(emailAddress);
    }
    public void typeTelephoneNumber(String telephoneNumber ){
        telephoneField.sendKeys(telephoneNumber);
    }
    public void typePassword(String password){
        passwordField.sendKeys(password);
    }
    public void typePasswordConfirm(String password){
        passwordConfirmField.sendKeys(password);
    }
    public void clickOnYesBox(){
        yesSubscribeBox.click();
    }
    public void clickOnPrivatePolicyBox(){
        privatePolicyCheckBox.click();
    }
    public void clickOnContinueButton(){
        continueButton.click();
    }


}
