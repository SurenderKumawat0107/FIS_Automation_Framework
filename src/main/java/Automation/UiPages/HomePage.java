package Automation.UiPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BaseClass {

    @FindBy(id = "gh-ac")
    private WebElement searchBox;

    @FindBy(id = "gh-btn")
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchForItem(String item) {
        searchBox.sendKeys(item);
        searchButton.click();
    }

//    private WebDriver driver;
//    private By searchBox = By.id("gh-ac");
//    private By searchButton = By.id("gh-btn");

    //public HomePage(WebDriver driver) {
     //   this.driver = driver;
  //  }

//    public void searchForItem(String item) {
//        driver.findElement(searchBox).sendKeys(item);
//        driver.findElement(searchButton).click();
//    }

}
