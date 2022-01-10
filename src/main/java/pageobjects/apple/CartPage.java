package pageobjects.apple;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage {
    WebDriver driver;
    By productNameSelector = By.cssSelector("[data-autom='bag-item-name']");
    By cartTitleSelector = By.cssSelector(".rs-bag-header ");
    By productPriceSelector = By.cssSelector(".rs-iteminfo-price > p");
    By subTotalPriceSelector = By.cssSelector("[data-autom='bagrs-summary-subtotalvalue']");
    By totalPriceSelector = By.cssSelector("[data-autom='bagtotalvalue']");
    int timeoutWait= 10;

    public CartPage (WebDriver driver){
        this.driver =driver;
    }

    public String getProductName(int index){
        List<WebElement> listOfProductName = driver.findElements(productNameSelector);
        return listOfProductName.get(index).getText();
    }
    public String getCartTitle(){
        return driver.findElement(cartTitleSelector).getText();
    }
    public String getProductPrice(int index) {
        List<WebElement> listOfProductPrices = driver.findElements(productPriceSelector);
        return listOfProductPrices.get(index).getText();
    }
    public String getSubTotal(){
        return driver.findElement(subTotalPriceSelector).getText();
    }
    public String getTotal() {
        return driver.findElement(totalPriceSelector).getText();
    }
}
