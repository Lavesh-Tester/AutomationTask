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
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/products");
    }

    @Test
    public void testSearchProduct() throws InterruptedException {
        
        HomePage homePage = new HomePage(driver);
        homePage.enterSearchText("Tshirt");
        homePage.clickSearchButton();

        Thread.sleep(3000);

       
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        boolean isVisible = searchResultsPage.isProductListVisible();

        Assert.assertTrue(isVisible, "Search result not visible!");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
    	
    	 Thread.sleep(3000);
        driver.quit();
    }
}
