import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class UberEatsTests {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://www.ubereats.com/fr");
        driver.manage().window().maximize();
        //Close cookies
        WebElement buttonCookies = driver.findElement(By.cssSelector("[class='bc gh gi gl bj bk bl bm bn bo bt bu ba bb']"));
        buttonCookies.click();
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test
    public void addBurgerToCart(){

        // Arrange
        int timeoutSearchLoad = 30;
        By searchLocation = By.id("location-typeahead-home-input");
        String Address = "La Defense";
        By searchBurgersCategorie = By.cssSelector("[alt='Burgers']");
        By searchFirstRestaurant = By.cssSelector("a[href^='/fr/store/king-marcel-nanterre/07TTIgUiQPWyz4uq4_H35w'] > h3");
        By firstBurgerMenu = By.cssSelector("div[tabindex='0']");
        By commandButton = By.cssSelector(".spacer._24 + button.b8");
        By cartbuttonSelector = By.cssSelector("#wrapper > header > div > div > div.gg.ah.hq.bf > div.ah.i5.i6.i7.cf.ag > button > div");
        String OrderItems="1";


        // Act
        WebElement barreRecherche = driver.findElement(searchLocation);
        barreRecherche.sendKeys(Address);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        barreRecherche.sendKeys(Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSearchLoad));
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBurgersCategorie));
        driver.findElement(searchBurgersCategorie).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(searchFirstRestaurant));
        driver.findElement(searchFirstRestaurant).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(firstBurgerMenu));
        driver.findElements(firstBurgerMenu).get(0).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(commandButton));
        driver.findElement(commandButton).click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(commandButton));

        // Assert
        WebElement cart = driver.findElement(cartbuttonSelector);
        Assert.assertTrue(cart.getText().contains(OrderItems), "The order does not contain 1 item");
    }
}
