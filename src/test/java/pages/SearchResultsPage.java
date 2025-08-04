package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage {
    WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locator to check if results are displayed
    By productList = By.cssSelector(".features_items");

    // Method to check product result visibility
    public boolean isProductListVisible() {
        return driver.findElement(productList).isDisplayed();
    }
}
