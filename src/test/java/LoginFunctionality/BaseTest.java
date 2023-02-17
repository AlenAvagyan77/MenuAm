package LoginFunctionality;

import driver.BrowserTypes;
import driver.DriverFactory;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    public static void initDriver() {
        DriverFactory.initDriver(BrowserTypes.CHROME);
    }

    public static void tearDown(WebDriver driver) {
        if (driver != null) {
            driver.quit();
        }
    }
}
