package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver driver){
        super();
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#payment-address > div:nth-child(2) > div.custom-control.custom-radio > label")
    private WebElement useExistingAddressBox;
    @FindBy(css = "#form-checkout > div.row > div.col-lg-7.mb-5.mb-lg-0 > div > div:nth-child(6) > label")
    private WebElement termsAndConditionsBox;
    @FindBy(id = "button-save")
    private WebElement saveOrderButton;

    @FindBy(id = "input-payment-firstname")
    private WebElement firstNameField;
    @FindBy(id = "input-payment-lastname")
    private WebElement lastNameField;
    @FindBy(id = "input-payment-email")
    private WebElement emailField;
    @FindBy(id = "input-payment-telephone")
    private WebElement telephoneField;
    @FindBy(id = "input-payment-password")
    private WebElement passwordField;
    @FindBy(id = "input-payment-confirm")
    private WebElement passwordConfirmField;
    @FindBy(id = "input-payment-company")
    private WebElement companyNameField;
    @FindBy(id = "input-payment-address-1")
    private WebElement firstAddressField;
    @FindBy(id = "input-payment-address-2")
    private  WebElement lastAddressField;
    @FindBy(id = "input-payment-city")
    private WebElement cityNameField;
    @FindBy(id = "input-payment-postcode")
    private WebElement postcodeField;

    @FindBy(css = "#input-payment-country > option:nth-child(186)")
    private WebElement countryFieldRomania;
    @FindBy(css = "#input-payment-zone > option:nth-child(15)")
    private WebElement regionFieldCluj;
    @FindBy(css = "#form-checkout > div.row > div.col-lg-7.mb-5.mb-lg-0 > div > div:nth-child(4) > label")
    private  WebElement policyButton;
    @FindBy(id = "button-save")
    private WebElement continueButton;

    public void clickOnUseExistingAddressBox(){
        useExistingAddressBox.click();
    }
    public void clickOnTermsAndConditionsBox(){
        termsAndConditionsBox.click();
    }
    public void clickOnSaveOrderButton(){
        saveOrderButton.click();
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
    public void typeCompanyName(String companyNameText){
        companyNameField.sendKeys(companyNameText);
    }
    public void typeFirstAddress(String firstAddressText){
        firstAddressField.sendKeys(firstAddressText);
    }
    public void typeLastAddress(String lastAddressText){
        lastAddressField.sendKeys(lastAddressText);
    }
    public void typeCityName(String cityNameText){
        cityNameField.sendKeys(cityNameText);
    }
    public void typePostcode(String postcodeText){
        postcodeField.sendKeys(postcodeText);
    }
    public void clickOnCountryFieldRomania() {
        countryFieldRomania.click();
    }
    public void clickOnRegionFieldCluj(){
        regionFieldCluj.click();
    }
    public void clickOnPolicyButton(){
        policyButton.click();
    }
    public void clickOnContinueButton(){
        continueButton.click();
    }
}
