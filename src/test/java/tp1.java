import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class tp1 {

    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        //Attente implicite
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
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
}
