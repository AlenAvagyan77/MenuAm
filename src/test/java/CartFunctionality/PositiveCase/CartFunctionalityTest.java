package CartFunctionality.PositiveCase;

import CartFunctionality.BaseTest;
import driver.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageFactories.*;
import constants.*;
import java.util.logging.Logger;


public class CartFunctionalityTest {
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
    public void SignInForMenuAm() {
        HomePageFactory homePageFactory = new HomePageFactory(DriverFactory.getDriver());
        homePageFactory.openHomePage();
        homePageFactory.verifyTheUserIsInCorrectPage();
        Assert.assertEquals(homePageFactory.actualTitle(), homePageFactory.expectedTitle());
        LOGGER.info(Messages.OPENED_THE_CORRECT_MENU_AM_PAGE);
        SignInPageFactory page_1_signIn = new SignInPageFactory(DriverFactory.getDriver());
        page_1_signIn.clickOnTheRegisterButton();
        page_1_signIn.clickOnTheEmailFieldAndEnterEmail(Data.VALID_EMAIL);
        page_1_signIn.clickOnThePasswordFieldAndEnterPassword(Data.VALID_PASSWORD);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(page_1_signIn.isTrue());
        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void SearchFunctionality() {
        SearchProductPageFactory searchProductPageFactory = new SearchProductPageFactory(DriverFactory.getDriver());
        LOGGER.info(Messages.TEST_ONE);
        searchProductPageFactory.clickOnTheSearchField(Data.FOOD_NAME);
        searchProductPageFactory.clickOnTheSubmitButton();
        searchProductPageFactory.waitForPageLoaded();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(searchProductPageFactory.isTrue());
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void AddAnyProductToShoppingCart() throws InterruptedException {
        AddAnyProductToSoppingCartFactory addAnyProductToSoppingCart = new AddAnyProductToSoppingCartFactory(
                DriverFactory.getDriver());
        addAnyProductToSoppingCart.clickOnTheHomePageButton();
        addAnyProductToSoppingCart.clickOnTheSavedAddress();
        addAnyProductToSoppingCart.clickOnTheMyAddressButton();
        addAnyProductToSoppingCart.clickOnTheConfirmButton();
        addAnyProductToSoppingCart.clickOnTheFirstProductButton();
        addAnyProductToSoppingCart.getTextOfOrder();
        addAnyProductToSoppingCart.clickOnTheAddToCartButton();
        addAnyProductToSoppingCart.waitUntilTheProductAddedToCart();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(addAnyProductToSoppingCart.isTrue());
        softAssert.assertAll();
    }

    @Test(priority = 4)
    public void ProductQuantityIncreasesWhenAddingProduct() throws InterruptedException {
        ProductQuantityFactory productQuantity = new ProductQuantityFactory(DriverFactory.getDriver());
        productQuantity.clickOnTheHomePageButton();
        int firstQuantity = productQuantity.getQuantityTextOfShoppingCart();
        LOGGER.info( Messages.TEST_TWO);
        LOGGER.info("There was " + firstQuantity + " product in the card.");
        productQuantity.clickOnTheFirstProduct();
        productQuantity.clickOnAddToCartButton();
        Thread.sleep(3000);
        int secondQuantity = productQuantity.getQuantityTextOfShoppingCart();
        LOGGER.info("After adding it became : " + secondQuantity);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotEquals(firstQuantity, secondQuantity);
        softAssert.assertAll();
    }

    @Test(priority = 5)
    public void DecreasedOneProductFromCart() throws InterruptedException {
        DecreasedOneProductFromTheCartFactory decreasedOneProductFromTheCart = new DecreasedOneProductFromTheCartFactory(
                DriverFactory.getDriver());
        decreasedOneProductFromTheCart.clickOnTheHomePageButton();
        int firstQuantity = decreasedOneProductFromTheCart.getQuantityTextOfShoppingCart();
        LOGGER.info(Messages.TEST_TREE);
        LOGGER.info("There was " + firstQuantity + " product in the card.");
        decreasedOneProductFromTheCart.clickOnTheBasketButton();
        Thread.sleep(3000);
        decreasedOneProductFromTheCart.clickOnTheMinusButton();
        decreasedOneProductFromTheCart.clickOnTheQuitFromCartButton();
        int secondQuantity = decreasedOneProductFromTheCart.getQuantityTextOfShoppingCart();
        LOGGER.info("After decreased it became : " + secondQuantity);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotEquals(firstQuantity, secondQuantity);
        softAssert.assertAll();
    }

    @Test(priority = 6)
    public void TotalPriceOfOrder() throws InterruptedException {
        TotalPriceOfOrderFactory totalPriceOfOrder =
                new TotalPriceOfOrderFactory(DriverFactory.getDriver());
        totalPriceOfOrder.clickOnTheHomePageButton();
        totalPriceOfOrder.clickOnTheBasketButton();
        Thread.sleep(2000);
        String firstTotalPrice = totalPriceOfOrder.getTextFromTotalPriceOfOrder();
        LOGGER.info(Messages.TEST_FOUR);
        LOGGER.info("Initial price : " + firstTotalPrice);
        totalPriceOfOrder.clickOnTheQuiteFromCartButton();
        totalPriceOfOrder.clickOnTheCaucasusInnButton();
        totalPriceOfOrder.clickOnAddToCartButton();
        Thread.sleep(2000);
        totalPriceOfOrder.clickOnTheBasketButton();
        Thread.sleep(2000);
        String secondTotalPrice = totalPriceOfOrder.getTextFromTotalPriceOfOrder();
        LOGGER.info("Final price : " + secondTotalPrice);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotEquals(firstTotalPrice, secondTotalPrice);
        softAssert.assertAll();

    }

    @Test(priority = 7)
    public void RemoveAllProductFromCart() throws InterruptedException {
        RemoveAllProductFromTheCartFactory removeAllProductFromTheCart =
                new RemoveAllProductFromTheCartFactory(DriverFactory.getDriver());
        removeAllProductFromTheCart.clickOnTheHomePageButton();
        removeAllProductFromTheCart.clickOnTheBasketButton();
        removeAllProductFromTheCart.clickOnTheDeleteAllProductsButton();
        removeAllProductFromTheCart.clickOnTheEmptyButton();
        Thread.sleep(2000);
        removeAllProductFromTheCart.getTextOfExpectedResult();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(removeAllProductFromTheCart.isTrue());
        softAssert.assertAll();

    }
}
