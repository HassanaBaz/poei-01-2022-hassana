package pageobjects.apple;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    WebDriver driver;
    By iphoneBarButtonSelector= By.cssSelector("ul.ac-gn-list > li:nth-child(5)");

    public MainPage(WebDriver driver){
        this.driver =driver;
    }

    public IphonePage openIphonePage (){
        driver.findElement(iphoneBarButtonSelector).click();

        IphonePage iphonePage = new IphonePage(driver);
        return iphonePage;
    }
}
