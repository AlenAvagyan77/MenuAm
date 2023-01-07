package pageFactories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Helper;

import static constants.Constants.*;

public class ProductQuantityFactory extends BasePage {

    public ProductQuantityFactory(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = HOME_PAGE_BUTTON)
    protected WebElement homePageButton;
    @FindBy(xpath = QUANTITY_OF_SHOPPING_CART)
    protected WebElement quantityOfShoppingCart;
    @FindBy(xpath = FIRST_PRODUCT)
    protected WebElement firstProduct;
    @FindBy(xpath = ADD_TO_CART_BUTTON_2)
    protected WebElement addToCartButton;


    public void clickOnTheHomePageButton() {
        Helper.waitUntilElementIsDisplayed(driver, homePageButton, 5);
        homePageButton.click();
    }

    public int getQuantityTextOfShoppingCart() {
        Helper.waitUntilElementIsDisplayed(driver, quantityOfShoppingCart, 5);
        return Integer.parseInt(quantityOfShoppingCart.getText());
    }

    public void clickOnTheFirstProduct() {
        Helper.waitUntilElementIsDisplayed(driver, firstProduct, 5);
        firstProduct.click();
    }

    public void clickOnAddToCartButton() {
        Helper.waitUntilElementIsDisplayed(driver, addToCartButton, 5);
        addToCartButton.click();
    }

}
