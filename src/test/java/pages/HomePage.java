package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By searchBox = By.id("search_product");
    By searchButton = By.id("submit_search");

    // Methods
    public void enterSearchText(String productName) {
        driver.findElement(searchBox).sendKeys(productName);
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }
}
