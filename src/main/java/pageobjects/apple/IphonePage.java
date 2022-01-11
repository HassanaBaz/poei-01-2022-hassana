package pageobjects.apple;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IphonePage {
    WebDriver driver;
    By iPhone13ProNewSelector= By.cssSelector("ul.chapternav-items > li:nth-child(1)");

    public IphonePage(WebDriver driver){
        this.driver =driver;
    }

    public Iphone13ProPage openIphone13ProPage(){

        driver.findElement(iPhone13ProNewSelector).click();

        Iphone13ProPage iphone13ProPage = new Iphone13ProPage(driver);
        return iphone13ProPage;
    }
}
