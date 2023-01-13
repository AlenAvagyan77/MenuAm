package pageFactories;

import org.bouncycastle.jcajce.provider.asymmetric.X509;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Helper;

import java.time.Duration;
import java.util.List;
import java.util.logging.Logger;

import static constants.Constants.*;

public class OrderFromClosedRestaurantPageFactory extends BasePage {
    private static final Logger LOGGER = Logger.getLogger(OrderFromClosedRestaurantPageFactory.class.getName());


    public OrderFromClosedRestaurantPageFactory(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = HOME_PAGE_BUTTON)
    protected WebElement homePageButton;
    @FindBy(xpath = ADD_TO_CART_BUTTON_3)
    protected WebElement addToCartButton;
    @FindBy(xpath = ORDER_NOW)
    protected WebElement orderNow;
    @FindBy(xpath = BASKET_BUTTON)
    protected WebElement basketButton;
    @FindBy(xpath = PAY_IN_PLACE_BUTTON)
    protected WebElement payInPlaceButton;
    @FindBy(xpath = ORDER_BUTTON)
    protected WebElement orderButton;
    @FindBy(xpath = EXPECTED_MESSAGE)
    protected List<WebElement> expectedMessage;
    @FindBy(xpath = GOOD_BUTTON)
    protected WebElement goodButton;
    @FindBy(xpath = CLOSED_RESTAURANTS)
    protected List<WebElement> listOfItem;
    @FindBy(xpath = SAVED_ADDRESS)
    protected WebElement savedAddresses;
    @FindBy(xpath = MY_ADDRESS_BUTTON)
    protected WebElement myAddressButton;
    @FindBy(xpath = CONFIRM_BUTTON)
    protected WebElement confirmButton;

    public void clickOnTheSavedAddress() {
        Helper.waitUntilElementIsDisplayed(driver, savedAddresses,10);
        savedAddresses.click();
    }

    public void clickOnTheMyAddressButton() {
        Helper.waitUntilElementIsDisplayed(driver, myAddressButton,10);
        myAddressButton.click();
    }

    public void clickOnTheConfirmButton() {
        try {
            Helper.waitUntilElementIsDisplayed(driver, confirmButton,10);
            if (confirmButton.isDisplayed()) {
                confirmButton.click();
            }
        } catch (Exception e) {

        }
    }

    public void clickOnTheHomePageButton() {
        Helper.waitUntilElementIsDisplayed(driver, homePageButton, 5);
        homePageButton.click();
    }

    public void clickOnTheRestaurantButton() {
        try {
            for (int i = 0; i < listOfItem.size(); i++) {
                Helper.waitUntilVisibilityOfAllElement(driver, listOfItem, 10);
                if (listOfItem.get(i).getText().contains("ՓԱԿ Է")) {
                    listOfItem.get(i).click();
                    break;
                }
            }
        } catch (Exception e) {

        }
    }

    public void clickOnTheAddToCartButton() {
        Helper.waitUntilElementIsDisplayed(driver, addToCartButton, 10);
        addToCartButton.click();
    }

    public void clickOnTheBasketButton() {
        Helper.waitUntilElementIsDisplayed(driver, basketButton, 5);
        basketButton.click();
    }

    public void clickOnTheOrderNow() {
        Helper.waitUntilElementIsDisplayed(driver, orderNow, 10);
        orderNow.click();
    }

    public void scrollUp(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Scroll down till the bottom of the page
        js.executeScript("window.scrollBy(0,-600)");
    }

    public void clickOnThePayInPlaceButton() {
        Helper.waitUntilElementIsDisplayed(driver, payInPlaceButton, 10);
        payInPlaceButton.click();
    }

    public void clickOnTheOrderButton() {
        Helper.waitUntilElementIsDisplayed(driver, orderButton, 10);
        orderButton.click();
    }

    public void getTextOfMessage() {
        Helper.waitUntilVisibilityOfAllElement(driver, expectedMessage, 10);
        for (WebElement element : expectedMessage) {
            LOGGER.info(element.getText());
        }
    }
    public boolean isTrue(){
        if (goodButton.isDisplayed()){
            return true;
        }else {
            return false;
        }
    }
}
