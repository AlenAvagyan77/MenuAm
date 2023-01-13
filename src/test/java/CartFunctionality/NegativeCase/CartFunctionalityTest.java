package CartFunctionality.NegativeCase;

import CartFunctionality.BaseTest;
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

    @BeforeMethod
    public void initDriver() {
        BaseTest.initDriver();
    }

    @AfterTest
    public void tearDown() {
        BaseTest.tearDown(DriverFactory.getDriver());
    }

    @Test(priority = 1)
    public void SignInForMenuAm() {
        HomePageFactory homePageFactory = new HomePageFactory(DriverFactory.getDriver());
        homePageFactory.openHomePage();
        homePageFactory.verifyTheUserIsInCorrectPage();
        Assert.assertEquals(homePageFactory.actualTitle(), homePageFactory.expectedTitle());
        LOGGER.info("--- Opened the correct MenuAm page ---");
        SignInPageFactory page_1_signIn = new SignInPageFactory(DriverFactory.getDriver());
        page_1_signIn.clickOnTheRegisterButton();
        page_1_signIn.clickOnTheEmailFieldAndEnterName("alen_avagyan_03@mail.ru");
        page_1_signIn.clickOnThePasswordFieldAndEnterPassword("043444255");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(page_1_signIn.isTrue());
        softAssert.assertAll();

    }

    @Test(priority = 2)
    public void OrderAnInappropriateProduct() throws InterruptedException {
        OrderAnInappropriateProductPageFactory orderAnInappropriateProduct = new
                OrderAnInappropriateProductPageFactory(DriverFactory.getDriver());
        LOGGER.info(" --- Verify the user can order a product with an inappropriate price. --- ");
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

    @Test(priority = 3)
    public void OrderFromClosedRestaurant() throws InterruptedException {
        OrderFromClosedRestaurantPageFactory orderFromClosedRestaurant =
                new OrderFromClosedRestaurantPageFactory(DriverFactory.getDriver());
        LOGGER.info(" --- Verify the user can order any item from the closed restaurant. ---");
        orderFromClosedRestaurant.clickOnTheHomePageButton();
        orderFromClosedRestaurant.clickOnTheSavedAddress();
        orderFromClosedRestaurant.clickOnTheMyAddressButton();
        orderFromClosedRestaurant.clickOnTheConfirmButton();
        orderFromClosedRestaurant.clickOnTheRestaurantButton();
        Thread.sleep(2000);
        orderFromClosedRestaurant.clickOnTheAddToCartButton();
        orderFromClosedRestaurant.clickOnTheBasketButton();
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