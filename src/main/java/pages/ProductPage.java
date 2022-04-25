package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static org.openqa.selenium.By.xpath;

public class ProductPage extends BasePage {

    private static final String ADD_TO_CART_BUTTON = "//li[contains(@class,'buttons__item ng')]";
    private static final String CART_BUTTON = "//rz-cart//button[@opencart] ";
    private static final String SUM_PRICE_TEXT = "//div[contains(@class,'sum-price')]//span[last()-1]";

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    Actions actions = new Actions(driver);

    public void clickOnAddToCartButton() {
        actions.moveToElement(driver.findElement(xpath(ADD_TO_CART_BUTTON))).perform();
        driver.findElement(xpath(ADD_TO_CART_BUTTON)).click();
    }

    public void clickOnCartButton() {
        driver.findElement(xpath(CART_BUTTON)).click();
    }

    public Integer getTextOfAmountProductsInCart() {
        return Integer.valueOf(driver.findElement(xpath(SUM_PRICE_TEXT)).getText());
    }
}
