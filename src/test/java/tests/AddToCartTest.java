package tests;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class AddToCartTest extends BaseTest {
    final static Logger logger = Logger.getLogger(AddToCartTest.class);

    @Parameters({"SEARCH_KEYWORD", "BRAND_KEYWORD", "COMPARATIVE_SUM_PRICE"})
    @Test(priority = 1)
    public void checkTotalPriceInCart(String SEARCH_KEYWORD, String BRAND_KEYWORD, int COMPARATIVE_SUM_PRICE) {
        PropertyConfigurator.configure("src/log4j.properties");
        logger.info("Test 1-'Check total price in the cart'");

        getHomePage().searchByKeyword(SEARCH_KEYWORD);
        logger.info("time to wait 1");
        getSearchResultsPage().waitForPageLoadComplete(Duration.ofSeconds(30));
        getSearchResultsPage().clickOnBrandButton(BRAND_KEYWORD);
        getSearchResultsPage().clickOnFilterButton();
        logger.info("time to wait 2");
        getSearchResultsPage().waitForPageLoadComplete(Duration.ofSeconds(30));
        getSearchResultsPage().clickOnProductButton();
        logger.info("time to wait 3");
        getProductPage().implicitWait(30);
        getProductPage().clickOnAddToCartButton();
        logger.info("time to wait 4");
        getProductPage().implicitWait(30);
        getProductPage().clickOnCartButton();
        assertTrue(getProductPage().getTextOfAmountProductsInCart() < COMPARATIVE_SUM_PRICE);
        logger.info("Total price match");
    }

}
