package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Helper {

    public static void waitUntilElementIsDisplayed(WebDriver driver, WebElement element, int timeout){
        new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitUntilVisibilityOfAllElement(WebDriver driver, List<WebElement> element, int timeout){
        new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.visibilityOfAllElements(element));
    }

    public static void clickOnTheElementIfDisplayed(WebElement element){
        if (element.isDisplayed()) {
            element.click();
        }
    }

}
