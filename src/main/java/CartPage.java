import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {
    WebDriver driver;

    By productPriceSelector = By.cssSelector("span.sc-product-price");
    By activeCartSubtotalSelector = By.cssSelector("#sc-subtotal-amount-activecart > span");
    By buyBoxCartSubtotalSelector = By.cssSelector("#sc-subtotal-amount-buybox > span");

    public CartPage(WebDriver driver){
        this.driver =driver;
    }
    public String getProductPrice(int index){
        List<WebElement> listOfProductPrices = driver.findElements(productPriceSelector);
        return listOfProductPrices.get(index).getText();
    }
    public String getActiveCartSubTotal() {
        return driver.findElement(activeCartSubtotalSelector).getText();
    }
    public String getBuyCartSubTotal() {
        return driver.findElement(buyBoxCartSubtotalSelector).getText();
    }
}
