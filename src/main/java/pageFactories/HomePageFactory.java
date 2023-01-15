package pageFactories;

import constants.Messages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.Logger;

import static constants.Constants.*;
import constants.Messages.*;

public class HomePageFactory extends BasePage {
    public HomePageFactory(WebDriver driver) {
        super(driver);
    }

    private static final Logger LOGGER = Logger.getLogger(HomePageFactory.class.getName());

    @FindBy(className = REGISTER_BUTTON)
    protected WebElement registerButton;

    public void openHomePage() {
        driver.manage().window().maximize();
        driver.get(HOME_PAGE_URL);
    }

    public void verifyTheUserIsInCorrectPage() {
        if (!registerButton.isDisplayed()) {
            LOGGER.warning(Messages.INCORRECT_PAGE_WAS_OPENED);
            driver.quit();
        }
    }
    
    public String actualTitle() {
        return driver.getTitle();
    }

    public String expectedTitle() {
        return HOME_PAGE_EXPECTED_TITLE;
    }
}
