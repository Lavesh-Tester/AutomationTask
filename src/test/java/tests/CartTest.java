package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class CartTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/products");
    }

    @Test
    public void testAddToCart() throws InterruptedException {
        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.sendKeys("Tshirt");

        WebElement searchButton = driver.findElement(By.cssSelector("button[type='button'][class*='search']"));
        searchButton.click();

        Thread.sleep(2000);

        WebElement addToCart = driver.findElement(By.xpath("(//a[text()='Add to cart'])[1]"));
        addToCart.click();

        Thread.sleep(2000);

        WebElement viewCart = driver.findElement(By.xpath("//u[text()='View Cart']"));
        viewCart.click();

        Thread.sleep(2000);

        WebElement productName = driver.findElement(By.xpath("//td[@class='cart_description']//a"));
        Assert.assertTrue(productName.getText().toLowerCase().contains("tshirt"));

        WebElement price = driver.findElement(By.xpath("//td[@class='cart_price']//p"));
        Assert.assertTrue(price.isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
