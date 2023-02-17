package CartFunctionality.NegativeCase;

import CartFunctionality.BaseTest;
import constants.Data;
import constants.Messages;
import driver.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageFactories.HomePageFactory;
import pageFactories.OrderAnInappropriateProductPageFactory;
import pageFactories.OrderFromClosedRestaurantPageFactory;
import pageFactories.SignInPageFactory;

import java.util.logging.Logger;


public class CartFunctionalityTest{
    private static final Logger LOGGER = Logger.getLogger(CartFunctionality.PositiveCase.CartFunctionalityTest.class.getName());

    @BeforeMethod(alwaysRun = true)
    public void initDriver() {
        BaseTest.initDriver();
    }


    @AfterTest(alwaysRun = true)
    public void tearDown() {
        BaseTest.tearDown(DriverFactory.getDriver());
    }

    @Test(priority = 1, groups = {"General"})
    public void SignInForMenuAm() throws InterruptedException {
        HomePageFactory homePageFactory = new HomePageFactory(DriverFactory.getDriver());
        homePageFactory.openHomePage();
        homePageFactory.verifyTheUserIsInCorrectPage();
        Assert.assertEquals(homePageFactory.actualText(), homePageFactory.expectedText());
        LOGGER.info(Messages.OPENED_THE_CORRECT_MENU_AM_PAGE);
        SignInPageFactory page_1_signIn = new SignInPageFactory(DriverFactory.getDriver());
        page_1_signIn.clickOnTheRegisterButton();
        page_1_signIn.clickOnThePhoneButton();
        page_1_signIn.clickOnTheEmailFieldAndEnterEmail(Data.VALID_PHONE_NUMBER);
        page_1_signIn.clickOnThePasswordFieldAndEnterPassword(Data.VALID_PASSWORD);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(page_1_signIn.isTrue());
        softAssert.assertAll();

    }

    @Test(priority = 2, groups = {"1"})
    public void OrderAnInappropriateProduct() throws InterruptedException {
        OrderAnInappropriateProductPageFactory orderAnInappropriateProduct = new
                OrderAnInappropriateProductPageFactory(DriverFactory.getDriver());
        LOGGER.info(Messages.Messages1.TEST_ONE);
        orderAnInappropriateProduct.clickOnTheBasketButtonOne();
        Thread.sleep(2000);
        orderAnInappropriateProduct.deleteAllProducts();
        Thread.sleep(2000);
        orderAnInappropriateProduct.clickOnTheSavedAddress();
        orderAnInappropriateProduct.clickOnTheMyAddressButton();
        orderAnInappropriateProduct.clickOnTheConfirmButton();
        orderAnInappropriateProduct.clickOnTheRestaurantForOrderButton();
        Thread.sleep(2000);
        orderAnInappropriateProduct.scrollUp();
        orderAnInappropriateProduct.clickOnTheAddToCartButton();
        Thread.sleep(2000);
        Thread.sleep(2000);
        orderAnInappropriateProduct.waitUntilTheProductAddedToCart();
        Thread.sleep(2000);
        orderAnInappropriateProduct.clickOnTheBasketButtonTwo();
        Thread.sleep(2000);
        orderAnInappropriateProduct.clickOnTheToOrderNowButton();
        Thread.sleep(2000);
        orderAnInappropriateProduct.getMessage();
        orderAnInappropriateProduct.clickOnTheGoodButton();
        orderAnInappropriateProduct.clickOnDeleteButton();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(orderAnInappropriateProduct.isTrue());
        softAssert.assertAll();
    }

    @Test(priority = 3, groups = {"1"})
    public void OrderFromClosedRestaurant() throws InterruptedException {
        OrderFromClosedRestaurantPageFactory orderFromClosedRestaurant =
                new OrderFromClosedRestaurantPageFactory(DriverFactory.getDriver());
        LOGGER.info(Messages.Messages1.TEST_TWO);
        orderFromClosedRestaurant.clickOnTheHomePageButton();
        orderFromClosedRestaurant.clickOnTheSavedAddress();
        orderFromClosedRestaurant.clickOnTheMyAddressButton();
        orderFromClosedRestaurant.clickOnTheConfirmButton();
        orderFromClosedRestaurant.clickOnTheRestaurantButton();
        Thread.sleep(2000);
        orderFromClosedRestaurant.clickOnTheAddToCartButton();
        orderFromClosedRestaurant.clickOnTheBasketButton();
        orderFromClosedRestaurant.clickOnThePLusButton();
        Thread.sleep(3000);
        orderFromClosedRestaurant.clickOnTheOrderNow();
        orderFromClosedRestaurant.scrollUp();
        orderFromClosedRestaurant.clickOnThePayInPlaceButton();
        orderFromClosedRestaurant.clickOnTheOrderButton();
        orderFromClosedRestaurant.getTextOfMessage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(orderFromClosedRestaurant.isTrue());
        softAssert.assertAll();
    }
}