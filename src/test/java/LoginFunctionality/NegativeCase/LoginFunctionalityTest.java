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
        Assert.assertEquals(homePageFactory.actualText(), homePageFactory.expectedText());
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
        softAssert.assertEquals(wrongEmail.actualText(), wrongEmail.expectedText());
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
        softAssert.assertEquals(emptyEmailField.actualText(), emptyEmailField.expectedText());
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
        softAssert.assertEquals(wrongPassword.actualText(), wrongPassword.expectedText());
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
        softAssert.assertEquals(emptyPasswordFactory.actualText(), emptyPasswordFactory.expectedText());
        softAssert.assertAll();
    }

    @Test(priority = 6)
    public void MoveToTheResetPasswordPage() throws InterruptedException {
        MoveToThePasswordResetPage resetPasswordPage = new
                MoveToThePasswordResetPage(DriverFactory.getDriver());
        resetPasswordPage.clickOnTheResetPasswordField();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(resetPasswordPage.isTrue());
        softAssert.assertAll();
        Thread.sleep(3000);

    }

    @Test(priority = 7)
    public void ResetPasswordEmptyPhoneNumberField(){
        ResetPassword resetPassword = new ResetPassword(DriverFactory.getDriver());
        resetPassword.clickOnTheSendToCodeButton();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(resetPassword.actualText(), resetPassword.expectedText());
        softAssert.assertAll();
    }

    @Test(priority = 8)
    public void ResetPasswordByWrongPhoneNumber(){
        ResetPassword resetPassword = new ResetPassword(DriverFactory.getDriver());
        resetPassword.clickOnThePhoneField();
        resetPassword.sendPhoneNumber();
        resetPassword.clickOnTheSendToCodeButton();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(resetPassword.actualTextOne(), resetPassword.expectedTitleOne());
        softAssert.assertAll();
    }

    @Test(priority = 10)
    public void ResetPasswordByWrongEmailField() {
        ResetPassword resetPassword = new ResetPassword(DriverFactory.getDriver());
        resetPassword.clickOnTheCheckBoxButtonOne();
        resetPassword.clickOnTheEmailField();
        resetPassword.sendWrongEmail();
        resetPassword.clickOnTheSendToCodeButton();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(resetPassword.actualTextTree(), resetPassword.expectedTextTree());
        softAssert.assertAll();
    }
}


