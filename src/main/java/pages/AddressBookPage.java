package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.Driver;

public class AddressBookPage extends BasePage {
    public AddressBookPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#column-right > div > a:nth-child(4)")
    private WebElement addressBookButton;
    @FindBy(css = "#content > div.buttons.clearfix.mb-4 > div.float-right > a")
    private WebElement newAddressButton;
    @FindBy(id = "input-firstname")
    private WebElement firstNameField;
    @FindBy(id = "input-lastname")
    private WebElement lastNameField;
    @FindBy(id = "input-company")
    private WebElement companyNameField;
    @FindBy(id = "input-address-1")
    private WebElement firstAddressField;
    @FindBy(id = "input-address-2")
    private  WebElement lastAddressField;
    @FindBy(id = "input-city")
    private WebElement cityNameField;
    @FindBy(id = "input-postcode")
    private WebElement postcodeField;

    @FindBy(css = "#input-country > option:nth-child(186)")
    private WebElement countryFieldRomania;
    @FindBy(css = "#input-zone > option:nth-child(15)")
    private WebElement regionFieldCluj;
    @FindBy(css = "#content > form > div > div.float-right > input")
    private WebElement continueButton;
    @FindBy(css = "#content > div.table-responsive > table > tbody > tr:nth-child(3) > td.text-right.p-3 > a.btn.btn-danger")
    private WebElement deleteButton;
    @FindBy(css = "#content > div.table-responsive > table > tbody > tr:nth-child(1) > td.text-right.p-3 > a.btn.btn-info")
    private WebElement editButton;
    public void clickOnAddressBookButton() {
        addressBookButton.click();
    }

    public void clickOnNewAddressButton() {
        newAddressButton.click();
    }

    public void typeFirstName(String firstNameText) {
        firstNameField.sendKeys(firstNameText);
    }

    public void typeLastName(String lastNameText) {
        lastNameField.sendKeys(lastNameText);
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
    public void clickOnContinueButton(){
        continueButton.click();
    }
    public void clickOnDeleteButton(){
        deleteButton.click();
    }
    public void clickOnEditButton(){
        editButton.click();
    }
}
