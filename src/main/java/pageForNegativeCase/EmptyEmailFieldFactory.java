package pageForNegativeCase;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageFactories.BasePage;
import utils.Helper;

import static constants.Constants.*;

public class EmptyEmailFieldFactory extends BasePage {
    public EmptyEmailFieldFactory(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = EMAIL_FIELD)
    protected WebElement emailField;
    @FindBy(xpath = FIRST_TEXT_FROM_LOGIN_PAGE)
    protected WebElement secondText;
    @FindBy(xpath = ACCESS_BUTTON)
    protected WebElement accessButton;


    public void clickOnTheEmailField(){
        Helper.waitUntilElementIsDisplayed(driver, emailField, 5);
        emailField.click();
    }


    public void deleteEmail(){
        Helper.waitUntilElementIsDisplayed(driver, emailField, 5);
        String s = Keys.chord(Keys.CONTROL, "a");
        emailField.sendKeys(s);
        emailField.sendKeys(Keys.DELETE);
    }
    public void clickOnAccessButton(){
        Helper.waitUntilElementIsDisplayed(driver, accessButton, 5);
        accessButton.click();
    }


    public String expectedText() {
        return SECOND_TEXT;
    }

    public String actualText() {
        Helper.waitUntilElementIsDisplayed(driver, secondText, 5);
        return secondText.getText();
    }


}
