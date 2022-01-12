import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.amazon.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;

public class AmazonTest {

    WebDriver driver;
    Logger log = LogManager.getLogger(AmazonTest.class);

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        log.info("Hassana was here");
        log.trace("trace");
        log.debug("debug");
        log.fatal("fatale");
        //Niveaux de log de + important au - important
        //FATAL > ERROR > WARNING > INFO > DEBUG > TRACE 

        driver.get("https://www.amazon.fr");
        driver.manage().window().maximize();

        driver.findElement(By.id("sp-cc-accept")).click();
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test
    public void HPChromebookAddToCartPriceTest(){
        //Arrange
        String productName="HP Chromebook x360 14a-ca0000sf";
        String expectedProductPrice = "369,00";

        //Act
        MainPage mainPage= new MainPage(driver);
        mainPage.searchProduct((productName));

        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.openResult(0);

        ProductPage productPage= new ProductPage(driver);
        productPage.addToCart();
        productPage.noCoverage();

        ConfirmationAddToCartPage confirmationAddToCartPage= new ConfirmationAddToCartPage(driver);
        confirmationAddToCartPage.openCart();

        CartPage cartPage= new CartPage(driver);
        String productPrice = cartPage.getProductPrice(0);
        String activeCartSubtotal =cartPage.getActiveCartSubTotal();
        String buyBoxCartSubtotal =cartPage.getBuyCartSubTotal();
        //Assert
        Assert.assertTrue(productPrice.contains(expectedProductPrice));
        Assert.assertTrue(activeCartSubtotal.contains(expectedProductPrice));
        Assert.assertTrue(buyBoxCartSubtotal.contains(expectedProductPrice));
    }
    /*@Test
    public void machineARacletteTest(){
        //Arrange
        String productName="machine a raclette";

        //Act
        pageobjects.amazon.MainPage mainPage= new pageobjects.amazon.MainPage(driver);
        mainPage.searchProduct((productName));

        pageobjects.amazon.SearchResultPage searchResultPage = new pageobjects.amazon.SearchResultPage(driver);
        searchResultPage.openResult(0);

        pageobjects.amazon.ProductPage productPage= new pageobjects.amazon.ProductPage(driver);
        productPage.addToCart();
        //Assert
    }*/
    @Test
    public void hoverTest(){
        By buttonSelector = By.id("nav-link-accountList");
        By myAccountLinkSelector = By.cssSelector("#nav-al-your-account .nav-title + a");
        int timeoutSearch= 2;
        WebElement button= driver.findElement(buttonSelector);
        Actions hover = new Actions(driver);
        hover.moveToElement(button);
        hover.perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds((timeoutSearch)));
        wait.until(ExpectedConditions.elementToBeClickable(myAccountLinkSelector)).click();

    }
}
