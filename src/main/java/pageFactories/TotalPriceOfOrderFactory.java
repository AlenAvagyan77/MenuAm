package pageFactories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Helper;

import static constants.Constants.*;

public class TotalPriceOfOrderFactory extends BasePage {
    public TotalPriceOfOrderFactory(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = HOME_PAGE_BUTTON)
    protected WebElement homePageButton;
    @FindBy(xpath = BASKET_BUTTON)
    protected WebElement basketButton;
    @FindBy(xpath = DIGIT_OF_PRICE)
    protected WebElement digitOfPrice;
    @FindBy(xpath = NAME_OF_PRICE)
    protected WebElement nameOfPrice;
    @FindBy(xpath = QUIT_FROM_CART_BUTTON)
    protected WebElement quitFromCartButton;
    @FindBy(xpath = CAUCASUS_INN_BUTTON)
    protected WebElement caucasusInnButton;
    @FindBy(xpath = ADD_TO_CART_BUTTON)
    protected WebElement addToCartButton;

    public void clickOnTheHomePageButton(){
        Helper.waitUntilElementIsDisplayed(driver, homePageButton, 5);
        homePageButton.click();
    }

    public void clickOnTheBasketButton(){
        Helper.waitUntilElementIsDisplayed(driver, basketButton, 5);
        basketButton.click();
    }

    public String getTextFromTotalPriceOfOrder(){
        Helper.waitUntilElementIsDisplayed(driver, basketButton, 5);
        return digitOfPrice.getText() + " "  + nameOfPrice.getText();
    }

    public void clickOnTheQuiteFromCartButton(){
        Helper.waitUntilElementIsDisplayed(driver, quitFromCartButton, 5);
        quitFromCartButton.click();
    }

    public void clickOnTheCaucasusInnButton(){
        Helper.waitUntilElementIsDisplayed(driver, caucasusInnButton, 5);
        caucasusInnButton.click();
    }

    public void clickOnAddToCartButton(){
        Helper.waitUntilElementIsDisplayed(driver, addToCartButton, 5);
        addToCartButton.click();
    }
}
