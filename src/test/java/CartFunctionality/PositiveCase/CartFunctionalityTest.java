package CartFunctionality.PositiveCase;

import CartFunctionality.BaseTest;
import driver.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageFactories.*;

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
    public void SearchField() {
        SearchProductPageFactory searchProductPageFactory = new SearchProductPageFactory(DriverFactory.getDriver());
        searchProductPageFactory.clickOnTheSearchField("ՊաՊա Պիցցա");
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
        LOGGER.info("--- Verify the quantity of the product increases when Adding one item to the cart. --- ");
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
        LOGGER.info("--- Verify quantity has decreased when removing one product from the cart. --- ");
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
        LOGGER.info(" --- Verify the total price has been added after adding the item to the cart. ---");
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
