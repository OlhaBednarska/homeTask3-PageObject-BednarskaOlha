package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.By.xpath;

public class SearchResultsPage extends BasePage {

    private static final String FILTER_BUTTON = "//select[contains(@class,'select-css')]";
    private static final String EXPENSIVE_FILTER_BUTTON = "//option[contains(@value,'expensive')]";
    private static final String PRODUCT_BUTTON = "//a[contains(@class,'tile__heading')]";
    private final List<WebElement> BRAND_BUTTON = driver.findElements(xpath("//a[contains(@href,'producer')]"));

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnBrandButton(final String brand) {
        for (WebElement list : BRAND_BUTTON) {
            if (list.getText().contains(brand)) {
                list.click();
                break;
            }
        }
    }

    public void clickOnFilterButton() {
        driver.findElement(xpath(FILTER_BUTTON)).click();
        driver.findElement(xpath(EXPENSIVE_FILTER_BUTTON)).click();
    }

    public void clickOnProductButton() {
        driver.findElement(xpath(PRODUCT_BUTTON)).click();
    }

}
