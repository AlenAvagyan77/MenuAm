package pageFactories;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.Logger;

import static constants.Constants.*;

public class SignInPageFactory extends BasePage {

    private static final Logger LOGGER = Logger.getLogger(SignInPageFactory.class.getName());

    public SignInPageFactory(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = PHONE_BUTTON)
    protected WebElement phoneButton;
    @FindBy(className = REGISTER_BUTTON)
    protected WebElement registerButton;
    @FindBy(xpath = EMAIL_FIELD)
    protected WebElement emailField;
    @FindBy(xpath = PASSWORD_FIELD)
    protected WebElement passwordField;
    @FindBy(xpath = SEARCH_FIELD)
    protected WebElement searchField;


    public void clickOnTheRegisterButton() {
        registerButton.click();
    }
    public void clickOnThePhoneButton(){
        phoneButton.click();
    }
    public void clickOnTheEmailFieldAndEnterEmail(String enterEmail){
        emailField.click();
        emailField.sendKeys(enterEmail);
    }

    public void clickOnThePasswordFieldAndEnterPassword(String password) {
        passwordField.click();
        passwordField.sendKeys(password, Keys.ENTER);
        LOGGER.info(" --- LogIn was successful ---");
    }

    public boolean isTrue(){
        if (searchField.isDisplayed()){
            return true;
        }else {
            return false;
        }
    }
}
