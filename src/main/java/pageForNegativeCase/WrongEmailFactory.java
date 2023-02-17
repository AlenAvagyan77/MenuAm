package pageForNegativeCase;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageFactories.BasePage;
import utils.Helper;

import static constants.Constants.*;

public class WrongEmailFactory extends BasePage {


    public WrongEmailFactory(WebDriver driver) {
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
    @FindBy(xpath = FIRST_TEXT_FROM_LOGIN_PAGE)
    protected WebElement firstText;


    public void clickOnTheRegisterButton() {
        Helper.waitUntilElementIsDisplayed(driver, registerButton, 5);
        registerButton.click();
    }

    public void clickOnTheEmailFieldAndEnterEmail(String enterEmail){
        Helper.waitUntilElementIsDisplayed(driver, emailField, 5);
        emailField.click();
        emailField.sendKeys(enterEmail);
    }

    public void clickOnThePasswordFieldAndEnterPassword(String password) {
        Helper.waitUntilElementIsDisplayed(driver, passwordField, 5);
        passwordField.click();
        passwordField.sendKeys(password, Keys.ENTER);
    }
    public String actualTitle(){
        Helper.waitUntilElementIsDisplayed(driver, firstText, 5);
        return firstText.getText();
    }

    public String expectedTitle(){ return FIRST_TITLE;};









}
