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


}
