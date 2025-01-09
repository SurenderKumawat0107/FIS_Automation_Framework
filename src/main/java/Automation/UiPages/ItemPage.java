package Automation.UiPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends BaseClass {

    @FindBy(id = "atcBtn_btn_1")
    private WebElement addToCartBttn;

    @FindBy(xpath = "//span[@id='gh-cart-n']//span[@class='gh-cart-icon']")
    private WebElement cartIcon;

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart() {
        addToCartBttn.click();
    }





//    private WebDriver driver;
//    private By addToCartButton = By.xpath("//button[contains(@id, 'atcRedesignId_btn')]");
//
//    private By cartCount = By.cssSelector(".gh-cart-qty");
//
//    public ItemPage(WebDriver driver) {
//        this.driver = driver;
//    }
//
//    public void addToCart() {
//        driver.findElement(addToCartButton).click();
//    }
//
//    public String getCartCount() {
//        return driver.findElement(cartCount).getText();
//    }
}
