package pageForNegativeCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageFactories.BasePage;
import utils.Helper;

import static constants.Constants.CHECKBOX_ONE;
import static constants.Constants.RESET_PASSWORD;

public class ResetPasswordPage extends BasePage {
    public ResetPasswordPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = RESET_PASSWORD)
    protected WebElement resetPasswordField;
    @FindBy(xpath = CHECKBOX_ONE)
    protected WebElement checkboxOne;



    public void clickOnTheResetPasswordField() {
        Helper.waitUntilElementIsDisplayed(driver, resetPasswordField, 5);
        resetPasswordField.click();
    }

    public boolean isTrue(){
        if (checkboxOne.isDisplayed()){
            return true;
        }else {
            return false;
        }
    }
}

