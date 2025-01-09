package Automation;

import Automation.UiPages.CartPage;
import Automation.UiPages.HomePage;
import Automation.UiPages.ItemPage;
import Automation.UiPages.SearchResultsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddToCartTest  {
    private WebDriver driver;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void verifyItemCanBeAddedToCart() {
        // Initialize pages
        HomePage homePage = new HomePage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        ItemPage itemListingPage = new ItemPage(driver);
        CartPage cartpage = new CartPage(driver);
        try {
            // Step 1: Open eBay
            homePage.openBrowser("https://www.ebay.com");

            // Step 2: Search for 'book'
            homePage.searchForItem("book");

            // Step 3: Click on the first book in the list
            searchResultsPage.clickOnFirstResult();

            // Switch to the new window
            for (String handle : driver.getWindowHandles()) {
                driver.switchTo().window(handle);
            }

            // Step 4: Add to cart

            itemListingPage.addToCart();

            // Step 5: Verify cart has been updated
            cartpage.openCart();
            int cartCount = cartpage.verifyCartItemCount();

            Assert.assertTrue(cartCount > 0, "Cart count did not update!");
        } catch (NoSuchElementException e) {
            System.out.println("Error: One or more elements were not found during the test execution.");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("An unexpected error occurred during the test.");
            e.printStackTrace();
        }
    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
