package LoginFunctionality.NegativeCase;

import CartFunctionality.BaseTest;
import CartFunctionality.PositiveCase.CartFunctionalityTest;
import constants.Data;
import constants.Messages;
import driver.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageFactories.HomePageFactory;
import pageForNegativeCase.*;

import java.util.logging.Logger;

public class LoginFunctionalityTest {

    private static final Logger LOGGER = Logger.getLogger(CartFunctionalityTest.class.getName());

    @BeforeMethod
    public void initDriver() {
        BaseTest.initDriver();
    }

    @AfterTest
    public void tearDown() {
        BaseTest.tearDown(DriverFactory.getDriver());
    }

    @Test(priority = 1)
    public void OpenMenuAm() {
        HomePageFactory homePageFactory = new HomePageFactory(DriverFactory.getDriver());
        homePageFactory.openHomePage();
        homePageFactory.verifyTheUserIsInCorrectPage();
        Assert.assertEquals(homePageFactory.actualTitle(), homePageFactory.expectedTitle());
        LOGGER.info(Messages.OPENED_THE_CORRECT_MENU_AM_PAGE);

    }

    @Test(priority = 2)
    public void WrongEmailCase() throws InterruptedException {
        WrongEmailFactory wrongEmail = new
                WrongEmailFactory(DriverFactory.getDriver());
        wrongEmail.clickOnTheRegisterButton();
        wrongEmail.clickOnTheEmailFieldAndEnterEmail(Data.INVALID_EMAIL);
        wrongEmail.clickOnThePasswordFieldAndEnterPassword(Data.VALID_PASSWORD);
        Thread.sleep(2000);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(wrongEmail.actualTitle(), wrongEmail.expectedTitle());
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void EmptyEmailFieldCase() throws InterruptedException {
        EmptyEmailFieldFactory emptyEmailField =
                new EmptyEmailFieldFactory(DriverFactory.getDriver());
        emptyEmailField.clickOnTheEmailField();
        emptyEmailField.deleteEmail();
        Thread.sleep(2000);
        emptyEmailField.clickOnAccessButton();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(emptyEmailField.actualTitle(), emptyEmailField.expectedTitle());
        softAssert.assertAll();

    }

    @Test(priority = 4)
    public void WrongPasswordCase() throws InterruptedException {
        WrongPasswordFactory wrongPassword =
                new WrongPasswordFactory(DriverFactory.getDriver());
        wrongPassword.clickOnTheEmailFieldAndRestoreEmail(Data.VALID_EMAIL);
        wrongPassword.clearPasswordField();
        wrongPassword.clickOnThePasswordFieldAndEnterPassword(Data.INVALID_PASSWORD);
        wrongPassword.clickOnAccessButton();
        Thread.sleep(2000);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(wrongPassword.actualTitle(), wrongPassword.expectedTitle());
        softAssert.assertAll();
    }

    @Test(priority = 5)
    public void EmptyPasswordCase() {
        EmptyPasswordFactory emptyPasswordFactory = new
                EmptyPasswordFactory(DriverFactory.getDriver());
        emptyPasswordFactory.clickOnThePasswordField();
        emptyPasswordFactory.removePassword();
        emptyPasswordFactory.clickOnTheAccessButton();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(emptyPasswordFactory.actualTitle(), emptyPasswordFactory.expectedTitle());
        softAssert.assertAll();

    }

    @Test(priority = 6)
    public void ResetPasswordPage(){
        ResetPasswordPage resetPasswordPage = new
                ResetPasswordPage(DriverFactory.getDriver());
        resetPasswordPage.clickOnTheResetPasswordField();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(resetPasswordPage.isTrue());
        softAssert.assertAll();



    }



}


