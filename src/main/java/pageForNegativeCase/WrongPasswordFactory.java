package pageForNegativeCase;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageFactories.BasePage;
import utils.Helper;

import static constants.Constants.*;

public class WrongPasswordFactory extends BasePage {

    public WrongPasswordFactory(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = EMAIL_FIELD)
    protected WebElement emailField;
    @FindBy(xpath = PASSWORD_FIELD)
    protected WebElement passwordField;
    @FindBy(xpath = ACCESS_BUTTON)
    protected WebElement accessButton;
    @FindBy(xpath = FIRST_TEXT_FROM_LOGIN_PAGE)
    protected WebElement firstText;




    public void clickOnTheEmailFieldAndRestoreEmail(String enterEmail){
        Helper.waitUntilElementIsDisplayed(driver, emailField, 5);
        emailField.click();
        emailField.sendKeys(enterEmail);
    }

    public void clearPasswordField(){
        Helper.waitUntilElementIsDisplayed(driver, passwordField, 5);
        String s = Keys.chord(Keys.CONTROL, "a");
        passwordField.sendKeys(s);
        passwordField.sendKeys(Keys.DELETE);
    }

    public void clickOnThePasswordFieldAndEnterPassword(String enterPassword){
        Helper.waitUntilElementIsDisplayed(driver, passwordField, 5);
        passwordField.click();
        passwordField.sendKeys(enterPassword);

    }
    public void clickOnAccessButton(){
        Helper.waitUntilElementIsDisplayed(driver, accessButton, 5);
        accessButton.click();
    }

    public String actualTitle(){
        Helper.waitUntilElementIsDisplayed(driver, firstText, 5);
        return firstText.getText();
    }

    public String expectedTitle(){ return FIRST_TITLE;};









}
