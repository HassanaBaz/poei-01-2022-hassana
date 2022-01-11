package pageobjects.apple;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConfirmationAddToCartPage {
    WebDriver driver;
    int timeoutWait= 5;
    By openCartButtonSelector = By.cssSelector("[data-autom='proceed']");

    public ConfirmationAddToCartPage (WebDriver driver){
        this.driver =driver;
    }

    public CartPage openCartPage() {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeoutWait));

        wait.until(ExpectedConditions.visibilityOfElementLocated(openCartButtonSelector));
        driver.findElement(openCartButtonSelector).click();

        CartPage cartPage = new CartPage(driver);
        return cartPage;
    }
}
