package pages;

import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class HomePage extends BasePage {

    private static final String SEARCH_INPUT = "//input[contains(@class,'search-form')]";
    private static final String SEARCH_BUTTON = "//button[contains(@class,'submit')]";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchByKeyword(final String keyword) {
        driver.findElement(xpath(SEARCH_INPUT)).sendKeys(keyword);
        driver.findElement(xpath(SEARCH_BUTTON)).click();
    }

}
