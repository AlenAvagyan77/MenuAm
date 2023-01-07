package pageFactories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Helper;

import java.util.logging.Logger;

import static constants.Constants.*;

public class SearchProductPageFactory extends BasePage {
    private static final Logger LOGGER = Logger.getLogger(SearchProductPageFactory.class.getName());

    public SearchProductPageFactory(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = SEARCH_FIELD)
    protected WebElement searchField;
    @FindBy(xpath = SUBMIT_BUTTON)
    protected WebElement submitButton;
    @FindBy(xpath = WAIT_FOR_PAGE_LOADED)
    protected WebElement waitForPageLoaded;
    @FindBy(xpath = FATHER_PIZZA)
    protected WebElement fatherPizzaButton;


    public void clickOnTheSearchField(String enterFoodName) {
        LOGGER.info(" --- Verify the user can search any product. ---");
        searchField.click();
        searchField.sendKeys(enterFoodName);
        LOGGER.info("The user has searched." + enterFoodName);
    }

    public void clickOnTheSubmitButton() {
        submitButton.click();
    }

    public void waitForPageLoaded() {
        Helper.waitUntilElementIsDisplayed(driver, waitForPageLoaded, 5);
    }

    public boolean isTrue(){
        if (fatherPizzaButton.isDisplayed()){
            return true;
        }else {
            return false;
        }
    }
}
