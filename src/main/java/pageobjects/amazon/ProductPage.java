package pageobjects.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    WebDriver driver;
    By addToCartButtonSelector = By.id("submit.add-to-cart");
    By addToWarrantyButtonSelector = By.cssSelector("#attachSiAddCoverage input");
    int timeoutSideBar = 3;
    By addNoCoverageButtonSelector = By.cssSelector("#attachSiNoCoverage input");
    By addToCartConfirmationSelector = By.id("add-to-cart-confirmation-image");
    int timeoutConfirmation = 5;

    public ProductPage(WebDriver driver){
        this.driver =driver;
    }
    public void addToCart(){
        driver.findElement(addToCartButtonSelector).click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeoutSideBar));
        wait.until(ExpectedConditions.elementToBeClickable(addToWarrantyButtonSelector));
    }
    public void noCoverage(){
        driver.findElement(addNoCoverageButtonSelector).click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeoutConfirmation));
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartConfirmationSelector));
    }
}
