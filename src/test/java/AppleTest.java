import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.amazon.*;
import pageobjects.apple.CartPage;
import pageobjects.apple.MainPage;

public class AppleTest {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();

        driver.get("https://www.apple.com/fr/");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test
    public void BuyIphone13ProTest() {
        //Arrange
        String expectedProductName = "iPhone 13 Pro Max 256 Go Bleu Alpin";
        String expectedPrice = "1 379,00";
        //Act
        MainPage mainPage = new MainPage(driver);
        CartPage cartPage = mainPage.openIphonePage()
                .openIphone13ProPage()
                .buy()
                .selectIphone13ProMax()
                .selectBlueAlphin()
                .select256Go()
                .noAppleTradeIn()
                .addToCart()
                .openCartPage();
        //Assert
        Assert.assertEquals(cartPage.getProductName(0),expectedProductName);
        Assert.assertTrue(cartPage.getCartTitle().contains(expectedPrice));
        Assert.assertTrue(cartPage.getProductPrice(0).contains(expectedPrice));
        Assert.assertTrue(cartPage.getSubTotal().contains(expectedPrice));
        Assert.assertTrue(cartPage.getTotal().contains(expectedPrice));
    }
}

