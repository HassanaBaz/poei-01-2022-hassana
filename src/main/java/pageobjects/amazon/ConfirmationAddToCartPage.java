package pageobjects.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationAddToCartPage {

    WebDriver driver;
    public ConfirmationAddToCartPage(WebDriver driver){
        this.driver =driver;
    }
    public void openCart(){
        By cartButtonSelector = By.id("nav-cart");
        driver.findElement(cartButtonSelector).click();
    }
}
