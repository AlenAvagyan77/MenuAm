package pageFactories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Helper;

import java.util.logging.Logger;

import static constants.Constants.*;

public class RemoveAllProductFromTheCartFactory extends BasePage {
    private static final Logger LOGGER = Logger.getLogger(RemoveAllProductFromTheCartFactory.class.getName());

    public RemoveAllProductFromTheCartFactory(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = HOME_PAGE_BUTTON)
    protected WebElement homePageButton;
    @FindBy(xpath = BASKET_BUTTON)
    protected WebElement basketButton;
    @FindBy(xpath = DELETE_ALL_PRODUCTS_BUTTON)
    protected WebElement deleteAllProductsButton;
    @FindBy(xpath = EMPTY_BUTTON)
    protected WebElement emptyButton;
    @FindBy(xpath = EXPECTED_RESULT)
    protected WebElement expectedResult;


    public void clickOnTheHomePageButton() {
        Helper.waitUntilElementIsDisplayed(driver, homePageButton, 5);
        homePageButton.click();
    }

    public void clickOnTheBasketButton() {
        Helper.waitUntilElementIsDisplayed(driver, basketButton, 5);
        basketButton.click();
    }

    public void clickOnTheDeleteAllProductsButton() {
        Helper.waitUntilElementIsDisplayed(driver, deleteAllProductsButton, 10);
        deleteAllProductsButton.click();
    }

    public void clickOnTheEmptyButton() {
        Helper.waitUntilElementIsDisplayed(driver, emptyButton, 5);
        emptyButton.click();
    }

    public void getTextOfExpectedResult() {
        Helper.waitUntilElementIsDisplayed(driver, expectedResult, 5);
        String ExpectedWriting = expectedResult.getText();
        LOGGER.info(String.format(" --- Verify the user can remove all items from the cart. ---\nExpected Result : %s",
                ExpectedWriting));
    }
    public boolean isTrue(){
        if (expectedResult.isDisplayed()){
            return true;
        }else {
            return false;
        }
    }

}
