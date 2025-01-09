package Automation.UiPages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchResultsPage extends BaseClass {

    @FindBy(xpath = "//*[@id=\"srp-river-results\"]/ul/li")
    List<WebElement> searchResultsList;

    @FindBy(css ="li[data-viewport*='trackableId']")
    private WebElement listItem;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnFirstResult() {

        if (searchResultsList.size() > 0) {
            WebElement firstResult = searchResultsList.get(0);
            String itemId = firstResult.getAttribute("id");
            System.out.println("Clicking on the first result: " + firstResult.getText());
            // Construct dynamic XPath for the first element's link (<a> tag)
            String dynamicXPath = "//*[@id='" + itemId + "']/div/div[2]/a";  // Adjust the XPath based on the actual structure

            System.out.println("Clicking on the first result with ID: " + itemId);


            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", firstResult);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicXPath)));

            // Click on the dynamically located element
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", link);

        } else {
            throw new NoSuchElementException("No search results found!");
        }

    }


    }
