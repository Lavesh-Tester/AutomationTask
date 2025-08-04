package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    public WebDriver driver;

    public void setup() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // replace with your chromedriver path
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.automationexercise.com/");
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
