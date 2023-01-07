package pageFactories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Helper;

import static constants.Constants.*;

public class DecreasedOneProductFromTheCartFactory extends BasePage {
    public DecreasedOneProductFromTheCartFactory(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = HOME_PAGE_BUTTON)
    protected WebElement homePageButton;
    @FindBy(xpath = QUANTITY_OF_SHOPPING_CART)
    protected WebElement quantityOfShoppingCart;
    @FindBy(xpath = BASKET_BUTTON)
    protected WebElement basketButton;
    @FindBy(xpath = MINUS_BUTTON)
    protected WebElement minusButton;
    @FindBy(xpath = QUIT_FROM_CART_BUTTON)
    protected WebElement quitFromCartButton;

    public void clickOnTheHomePageButton(){
        Helper.waitUntilElementIsDisplayed(driver, homePageButton, 5);
        homePageButton.click();
    }
    public int getQuantityTextOfShoppingCart(){
        Helper.waitUntilElementIsDisplayed(driver, quantityOfShoppingCart, 5);
        return Integer.parseInt(quantityOfShoppingCart.getText());
    }

    public void clickOnTheBasketButton(){
        Helper.waitUntilElementIsDisplayed(driver, basketButton, 5);
        basketButton.click();
    }

    public void clickOnTheMinusButton(){
        Helper.waitUntilElementIsDisplayed(driver, minusButton, 5);
        minusButton.click();
    }

    public void clickOnTheQuitFromCartButton(){
        Helper.waitUntilElementIsDisplayed(driver, quitFromCartButton, 5);
        quitFromCartButton.click();
    }

}
