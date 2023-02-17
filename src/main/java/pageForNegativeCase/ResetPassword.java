package pageForNegativeCase;

import constants.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageFactories.BasePage;
import utils.Helper;

import static constants.Constants.*;

public class ResetPassword extends BasePage {
    public ResetPassword(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = SEND_CODE)
    protected WebElement sendCodeButton;
    @FindBy(xpath = FIRST_TEXT_FROM_RESET_PAGE)
    protected WebElement firstText;
    @FindBy(xpath = PHONE_FIELD)
    protected WebElement phoneField;
    @FindBy(xpath = SECOND_TEXT_FROM_RESET_PAGE)
    protected WebElement secondText;
    @FindBy(xpath = CHECKBOX_ONE)
    protected WebElement checkBoxButton;
    @FindBy(xpath = THIRD_TEXT_FROM_RESET_PAGE)
    protected WebElement thirdText;
    @FindBy(xpath = EMAIL_FIELD_ONE)
    protected WebElement emailField;
    @FindBy(xpath = FIFTH_TEXT_FROM_RESET_PAGE)
    protected WebElement fifthText;


    public void clickOnTheSendToCodeButton() {
        sendCodeButton.click();
    }


    public String expectedText() {
        return FOURTH_TEXT;
    }

    public String actualText() {
        Helper.waitUntilElementIsDisplayed(driver, firstText, 5);
        return firstText.getText();
    }

    public void clickOnThePhoneField() {
        Helper.waitUntilElementIsDisplayed(driver, phoneField, 5);
        phoneField.click();
    }

    public void sendPhoneNumber() {
        phoneField.sendKeys(Data.INVALID_PHONE_NUMBER);
    }


    public String expectedTitleOne() {
        return FIFTH_TEXT;
    }

    public String actualTextOne() {
        Helper.waitUntilElementIsDisplayed(driver, secondText, 5);
        return secondText.getText();
    }

    public void clickOnTheCheckBoxButton() {
        checkBoxButton.click();
    }


    public String expectedTextTwo() {
        return SECOND_TEXT;
    }

    public String actualTextTwo() {
        Helper.waitUntilElementIsDisplayed(driver, thirdText, 5);
        return thirdText.getText();
    }
    public void clickOnTheCheckBoxButtonOne(){
        checkBoxButton.click();
    }

    public void clickOnTheEmailField(){
        emailField.click();
    }

    public void sendWrongEmail(){
        emailField.sendKeys(Data.INVALID_EMAIL_ONE);
    }

    public String expectedTextTree(){
        return SIXTH_TEXT;
    }
    public String actualTextTree(){
        Helper.waitUntilElementIsDisplayed(driver, fifthText, 5);
        return fifthText.getText();
    }


}
