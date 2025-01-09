package Automation.UiPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BaseClass{


    @FindBy(css = "a.gh-eb-li-a.gh-rvi-menu[aria-label*='Your shopping cart']")
    private WebElement cartLink;

    @FindBy(css = "a.gh-eb-li-a.gh-rvi-menu > i#gh-cart-n")
    private WebElement cartItemCount;
    public CartPage(WebDriver driver) {
        super(driver);
    }
    public void openCart() {
        cartLink.click();
    }

    public int verifyCartItemCount() {
        String itemCountText = cartItemCount.getText();
        int actualCount = Integer.parseInt(itemCountText);

        return actualCount;
    }
}
