package pageobjects.apple;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BuyIphone13ProPage {
    WebDriver driver;
    int timeoutWait= 10;
    //By buyIphone13ProTitle = By.cssSelector("[aria-label='iPhone 13 Pro']");
    By iphone13ProMaxSelector = By.cssSelector("[data-autom='dimensionScreensize6_7inch']+label");
    By iphoneColorSelector = By.cssSelector("[data-autom='dimensionColorsierrablue']+label");
    By iphone256GoSelector = By.cssSelector("[data-autom='dimensionCapacity256gb']+label");
    By iphoneNoTradeInSelector = By.cssSelector("[data-autom='choose-noTradeIn']+label");
    By addToCartButtonSelector = By.cssSelector(".button-block[data-autom='add-to-cart']");

    public BuyIphone13ProPage (WebDriver driver){
        this.driver =driver;
    }

    public BuyIphone13ProPage selectIphone13ProMax(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeoutWait));
        wait.until(ExpectedConditions.elementToBeClickable(iphone13ProMaxSelector));
        driver.findElement(iphone13ProMaxSelector).click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }
    public BuyIphone13ProPage selectBlueAlphin(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeoutWait));
        wait.until(ExpectedConditions.elementToBeClickable(iphoneColorSelector));

        driver.findElement(iphoneColorSelector).click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }
    public BuyIphone13ProPage select256Go(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeoutWait));

        wait.until(ExpectedConditions.elementToBeClickable(iphone256GoSelector));
        driver.findElement(iphone256GoSelector).click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }
    public BuyIphone13ProPage noAppleTradeIn(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeoutWait));

        wait.until(ExpectedConditions.elementToBeClickable(iphoneNoTradeInSelector));
        driver.findElement(iphoneNoTradeInSelector).click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }
    public ConfirmationAddToCartPage addToCart(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeoutWait));

        wait.until(ExpectedConditions.elementToBeClickable(addToCartButtonSelector));
        driver.findElement(addToCartButtonSelector).click();
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ConfirmationAddToCartPage confirmationAddToCartPage = new ConfirmationAddToCartPage(driver);
        return confirmationAddToCartPage;

    }
}
