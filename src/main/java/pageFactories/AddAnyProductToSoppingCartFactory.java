package pageFactories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Helper;

import java.util.logging.Logger;

import static constants.Constants.*;

public class AddAnyProductToSoppingCartFactory extends BasePage {
    private static final Logger LOGGER = Logger.getLogger(AddAnyProductToSoppingCartFactory.class.getName());

    public AddAnyProductToSoppingCartFactory(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = SAVED_ADDRESS)
    protected WebElement savedAddress;
    @FindBy(xpath = MY_ADDRESS_BUTTON)
    protected WebElement myAddressButton;
    @FindBy(xpath = HOME_PAGE_BUTTON)
    protected WebElement homePageButton;
    @FindBy(xpath = FIRST_PRODUCT_BUTTON)
    protected WebElement firstProductButton;
    @FindBy(xpath = ADD_TO_CART_BUTTON)
    protected WebElement addToCartButton;
    @FindBy(xpath = GET_TEXT_OF_ORDER)
    protected WebElement getTextOfOrder;
    @FindBy(xpath = BASKET_INDEX)
    protected WebElement basketIndex;
    @FindBy(xpath = CONFIRM_BUTTON)
    protected WebElement confirmButton;


    public void clickOnTheHomePageButton() {
        Helper.waitUntilElementIsDisplayed(driver, homePageButton, 5);
        homePageButton.click();
    }

    public void clickOnTheSavedAddress() {
        Helper.waitUntilElementIsDisplayed(driver, homePageButton, 5);
        savedAddress.click();
    }

    public void clickOnTheMyAddressButton() {
        Helper.waitUntilElementIsDisplayed(driver, homePageButton, 5);
        myAddressButton.click();
    }

    public void clickOnTheConfirmButton() {
        try {

            Helper.waitUntilElementIsDisplayed(driver, confirmButton, 5);
            Helper.clickOnTheElementIfDisplayed(confirmButton);
        }catch (Exception pass){

        }
    }
    public void clickOnTheFirstProductButton() {
        Helper.waitUntilElementIsDisplayed(driver, firstProductButton, 5);
        firstProductButton.click();
    }

    public void getTextOfOrder() {
        Helper.waitUntilElementIsDisplayed(driver, getTextOfOrder, 5);
        LOGGER.info(String.format(" --- Verify the user can add any product to the shopping cart.? ---\nThe user added: %s",
                getTextOfOrder.getText()));
    }

    public void clickOnTheAddToCartButton() throws InterruptedException {
        Helper.waitUntilElementIsDisplayed(driver, addToCartButton, 5);
        addToCartButton.click();
        Thread.sleep(5000);
    }

    public void waitUntilTheProductAddedToCart() {
        Helper.waitUntilElementIsDisplayed(driver, basketIndex, 5);
    }

    public boolean isTrue() {
        if (basketIndex.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }
}