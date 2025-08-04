package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pages.HomePage;
import pages.SearchResultsPage;

public class SearchTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:/tools/chromedriver.exe"); // 🔁 Replace with your local path
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/");
    }

    @Test
    public void testSearchProduct() throws InterruptedException {
        // Use HomePage class to search
        HomePage homePage = new HomePage(driver);
        homePage.enterSearchText("Tshirt");
        homePage.clickSearchButton();

        Thread.sleep(2000); // Wait for result to load

        // Use SearchResultsPage class to verify result
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        boolean isVisible = searchResultsPage.isProductListVisible();

        Assert.assertTrue(isVisible, "Search result not visible!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
