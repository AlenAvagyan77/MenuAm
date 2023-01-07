package CartFunctionality;

import driver.BrowserTypes;
import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

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
