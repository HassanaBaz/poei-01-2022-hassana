import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;


public class tp1 {

    WebDriver driver;
    @BeforeMethod
    public void setup(){
        URL seleniumGridUrl = null;
        try {
            seleniumGridUrl = new URL("http://127.0.0.1:4444");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new RemoteWebDriver(seleniumGridUrl, chromeOptions);

        //Attente implicite
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://www.amazon.fr");
        driver.manage().window().maximize();
        //Fermer cookies
        WebElement buttonCookies = driver.findElement(By.id("sp-cc-accept"));
        buttonCookies.click();
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
    //Chercher une machine à raclette dans la barre de recherche du site amazon
    @Test
    public void test1(){
        //Utiliser la barre de recherche
        WebElement barreRecherche = driver.findElement(By.id("twotabsearchtextbox"));
        barreRecherche.sendKeys("machine a raclette");
        barreRecherche.sendKeys(Keys.ENTER);
    }
    @Test
    public void test2(){
        //Utiliser la barre de recherche
        WebElement barreRecherche = driver.findElement(By.id("twotabsearchtextbox"));
        barreRecherche.sendKeys("machine a raclette");
        barreRecherche.sendKeys(Keys.ENTER);
        //Attente implicite

        //Selectioner le premier article
        WebElement premierArticle = driver.findElement(By.cssSelector("[cel_widget_id='MAIN-SEARCH_RESULTS-10']"));
        premierArticle.click();

        //Ajouter l'article dans le panier
        WebElement ajoutPanier= driver.findElement(By.cssSelector("[name='submit.add-to-cart']"));
        ajoutPanier.click();
    }
    /*@Test
    public void testLivres(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(By.id("nav-hamburger-menu")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".hmenu-item[data-menu-id='10']")));
        driver.findElement(By.cssSelector(".hmenu-item[data-menu-id='10']")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("ul.hmenu-visible > li:nth-child(3)")));
        driver.findElement(By.cssSelector("ul.hmenu-visible > li:nth-child(3)")).click();
    }*/
    @Test
    public void testMultipleElement(){

        // Arrange
        int expectedNumberOfResults = 60;
        String keyword = "machine a raclette";
        int timeoutSearchLoad = 10;
        By searchBarSelector = By.id("twotabsearchtextbox");
        By searchResultSelector = By.cssSelector("[data-component-type='s-search-result']");

        // Act
        WebElement barreRecherche = driver.findElement(searchBarSelector);
        barreRecherche.sendKeys( keyword + Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSearchLoad));
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultSelector));
        List<WebElement> listeDeResultat = driver.findElements(searchResultSelector);

        // Assert
        Assert.assertEquals(listeDeResultat.size(), expectedNumberOfResults, "The number of search results is not correct");

    }
}
