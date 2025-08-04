package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage {
	WebDriver driver;

	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
	}

	By productList = By.cssSelector(".features_items");

	public boolean isProductListVisible() {
		return driver.findElement(productList).isDisplayed();
	}
}
