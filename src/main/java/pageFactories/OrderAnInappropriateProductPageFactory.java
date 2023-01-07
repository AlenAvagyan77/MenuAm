package pageFactories;

import org.apache.commons.compress.archivers.zip.X000A_NTFS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Helper;

import java.util.List;
import java.util.logging.Logger;

import static constants.Constants.*;

public class OrderAnInappropriateProductPageFactory extends BasePage {
    private static final Logger LOGGER = Logger.getLogger(OrderAnInappropriateProductPageFactory.class.getName());

    public OrderAnInappropriateProductPageFactory(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = SAVED_ADDRESS)
    protected WebElement savedAddresses;
    @FindBy(xpath = MY_ADDRESS_BUTTON)
    protected WebElement myAddressButton;
    @FindBy(xpath = RESTAURANT_FOR_ORDER_BUTTON)
    protected WebElement restaurantForOrderButton;
    @FindBy(xpath = BASKET_BUTTON)
    protected WebElement basketButton;
    @FindBy(xpath = ADD_TO_CART_BUTTON)
    protected WebElement addToCartButton;
    @FindBy(xpath = LIST_OF_ITEM)
    protected List<WebElement> listOfItem;
    @FindBy(xpath = ADD_TO_SHOPPING_CART_BUTTON)
    protected WebElement addToShoppingCartButton;
    @FindBy(xpath = BASKET_INDEX)
    protected WebElement waitUntilTheProductAddedToCart;
    @FindBy(xpath = TO_ORDER_NOW_BUTTON)
    protected WebElement toOrderNowButton;
    @FindBy(xpath = MUST_GET_THIS_MESSAGE)
    protected WebElement mustGetThisMessage;
    @FindBy(xpath = CONFIRM_BUTTON)
    protected WebElement confirmButton;
    @FindBy(xpath = EMPTY_BUTTON)
    protected WebElement emptyButton;
    @FindBy(xpath = GOOD_BUTTON)
    protected WebElement goodButton;
    @FindBy(xpath = DELETE_ITEM_BUTTON)
    protected WebElement deleteItemButton;
    @FindBy(xpath = TRY_AGAIN_BUTTON)
    protected WebElement tryAgainButton;

    public void clickOnTheBasketButtonOne() {
        basketButton.click();
    }

    public void deleteAllProducts() {
        try {
            Helper.waitUntilElementIsDisplayed(driver, deleteItemButton, 5);
            if (deleteItemButton.isDisplayed()) {
                deleteItemButton.click();
                Helper.waitUntilElementIsDisplayed(driver, emptyButton, 5);
                emptyButton.click();
            }
        } catch (Exception e) {

        }
    }

    public void theWayOfTest(){
        try {
            Helper.waitUntilElementIsDisplayed(driver, deleteItemButton, 5);
            if (tryAgainButton.isDisplayed()) {
                tryAgainButton.click();
            }
        } catch (Exception e) {

        }
    }
    public void clickOnTheSavedAddress() {
        Helper.waitUntilElementIsDisplayed(driver, savedAddresses, 10);
        savedAddresses.click();
    }

    public void clickOnTheMyAddressButton() {
        Helper.waitUntilElementIsDisplayed(driver, myAddressButton, 10);
        myAddressButton.click();
    }

    public void clickOnTheConfirmButton() {
        try {
            Helper.waitUntilElementIsDisplayed(driver, confirmButton, 10);
            Helper.clickOnTheElementIfDisplayed(confirmButton);
        } catch (Exception e) {

        }
    }

    public void clickOnTheRestaurantForOrderButton() {
        Helper.waitUntilElementIsDisplayed(driver, restaurantForOrderButton, 5);
        restaurantForOrderButton.click();
    }

    public void clickOnTheAddToCartButton() {
        for (int i = 0; i < listOfItem.size(); i++) {
            int itemPrice = Integer.parseInt(listOfItem.get(i).getText());
            LOGGER.info("Product price is a " + itemPrice);
            if (itemPrice < 2000) {
                Helper.waitUntilElementIsDisplayed(driver, addToCartButton, 5);
                addToCartButton.click();
                break;
            }
        }
    }

    public void clickOnTheAddToShoppingCartButton() {
        try {
            Helper.waitUntilElementIsDisplayed(driver, addToShoppingCartButton, 7);
            addToShoppingCartButton.click();
        } catch (Exception e) {

        }
    }

    public void waitUntilTheProductAddedToCart() {
        Helper.waitUntilElementIsDisplayed(driver, waitUntilTheProductAddedToCart, 10);
    }

    public void clickOnTheBasketButtonTwo() {
        Helper.waitUntilElementIsDisplayed(driver, basketButton, 5);
        basketButton.click();
    }

    public void clickOnTheToOrderNowButton() {
        Helper.waitUntilElementIsDisplayed(driver, toOrderNowButton, 5);
        toOrderNowButton.click();
    }

    public void getMessage() {
        Helper.waitUntilElementIsDisplayed(driver, mustGetThisMessage, 5);
        LOGGER.info(String.format("The order failed : %s\n", mustGetThisMessage.getText()));
    }

    public void clickOnTheGoodButton() {
        Helper.waitUntilElementIsDisplayed(driver, goodButton, 5);
        goodButton.click();
    }

    public void clickOnDeleteButton() {
        Helper.waitUntilElementIsDisplayed(driver, deleteItemButton, 5);
        deleteItemButton.click();
        Helper.waitUntilElementIsDisplayed(driver, emptyButton, 5);
        emptyButton.click();
    }
    public boolean isTrue(){
        if (deleteItemButton.isDisplayed()){
            return true;
        }else {
            return false;
        }
    }
}
