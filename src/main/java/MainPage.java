import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    WebDriver driver;
    By searchBarSelector = By.id("twotabsearchtextbox");
    int timeoutSearch = 0;
    By searchResultSelector= By.cssSelector("[data-component-type='s-search-result']");

    public MainPage(WebDriver driver){
        this.driver =driver;
    }
    public void searchProduct(String productName){
        driver.findElement(searchBarSelector).sendKeys(productName + Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds((timeoutSearch)));
        wait.until(ExpectedConditions.elementToBeClickable(searchResultSelector));
    }
}
