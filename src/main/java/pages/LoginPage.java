package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "input-email")
    private WebElement emailField;
    @FindBy(id = "input-password")
    private WebElement passwordField;
    @FindBy(css = "input[type=\"submit\"]")
    private WebElement loginButton;
    @FindBy(css ="#column-right > div > a:nth-child(3)" )
    private WebElement forgottenPasswordButton;

    public void typeEmail(String text) {
        emailField.sendKeys(text);
    }
    public void typePassword(String text) {
        passwordField.sendKeys(text);
    }
    public void clickOnLoginButton() {
        loginButton.click();
    }
    public void clickOnForgottenPasswordButton(){
        forgottenPasswordButton.click();
    }
}
