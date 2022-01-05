import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class tp1 {

    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.fr");
        driver.manage().window().maximize();
        //Fermer cookies
        WebElement buttonCookies = driver.findElement(By.id("sp-cc-accept"));
        buttonCookies.click();
    }
    //Chercher une machine à raclette dans la barre de recherche du site amazon
    @Test
    public void test1(){
        //Utiliser la barre de recherche
        WebElement barreRecherche = driver.findElement(By.id("twotabsearchtextbox"));
        barreRecherche.sendKeys("machine a raclette");
        barreRecherche.sendKeys(Keys.ENTER);
        driver.quit();
    }

    @Test
    public void test2(){
        //Utiliser la barre de recherche
        WebElement barreRecherche = driver.findElement(By.id("twotabsearchtextbox"));
        barreRecherche.sendKeys("machine a raclette");
        barreRecherche.sendKeys(Keys.ENTER);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Selectioner le premier article
        WebElement premierArticle = driver.findElement(By.cssSelector("[cel_widget_id='MAIN-SEARCH_RESULTS-10']"));
        premierArticle.click();
        //Ajouter l'article dans le panier
        WebElement ajoutPanier= driver.findElement(By.cssSelector("[data-action='dp-pre-atc-declarative']"));
        ajoutPanier.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
