package pageForNegativeCase;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageFactories.BasePage;
import utils.Helper;

import static constants.Constants.*;

public class EmptyPasswordFactory extends BasePage {
    public EmptyPasswordFactory(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = PASSWORD_FIELD)
    protected WebElement passwordField;
    @FindBy(xpath = FIRST_TEXT_FROM_LOGIN_PAGE)
    protected WebElement firstText;
    @FindBy(xpath = ACCESS_BUTTON)
    protected WebElement accessButton;





    public void clickOnThePasswordField() {
        Helper.waitUntilElementIsDisplayed(driver, passwordField, 5);
        passwordField.click();
    }

    public void removePassword(){
        Helper.waitUntilElementIsDisplayed(driver, passwordField, 5);
        String s = Keys.chord(Keys.CONTROL, "a");
        passwordField.sendKeys(s);
        passwordField.sendKeys(Keys.DELETE);
    }
    public void clickOnTheAccessButton(){
        Helper.waitUntilElementIsDisplayed(driver, accessButton, 5);
        accessButton.click();
    }


    public String actualText(){
        Helper.waitUntilElementIsDisplayed(driver, firstText, 5);
        return firstText.getText();
    }

    public String expectedText(){
        return THIRD_TEXT;
    }





}
