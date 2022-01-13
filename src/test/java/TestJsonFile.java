import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestJsonFile {

    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();

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
    public void testAmazon1() throws IOException, InterruptedException {
        try {
            //Utiliser la barre de recherche
            WebElement barreRecherche = driver.findElement(By.id("twotabsearchtextbox"));
            barreRecherche.sendKeys("machine a raclette");
            barreRecherche.sendKeys(Keys.ENTER);
            preparationJson("PASS");
            executeCurl();
        }
        catch (WebDriverException e) {
            e.printStackTrace();
            preparationJson("FAIL");
            executeCurl();
            throw e;
        }

    }
    public void preparationJson(String status){
        JSONObject jsonObject = new JSONObject();
        JSONArray listTests = new JSONArray();
        JSONObject newTest = new JSONObject();
        newTest.put("status", status);
        newTest.put("testKey", "TEST-311");
        newTest.put("comment", "Hassana");

        listTests.add(newTest);
        jsonObject.put("tests", listTests);
        jsonObject.put("testExecutionKey", "TEST-310");
        try (FileWriter file = new FileWriter(System.getProperty("user.dir") + "/report.json")) {
            file.write(jsonObject.toJSONString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void executeCurl() throws IOException, InterruptedException {

        String curlCommand = "curl -k -H \"Content-Type: application/json\" -H \"Authorization: Bearer "
                + "Uc1PGGXcJMWzyH8ef9ukE6BA="
                + "\" --data \"@"
                + "report.json" + "\" "
                + "https://jira.web.bpifrance.fr/rest/raven/1.0/import/execution";

        System.out.println(curlCommand);
        ProcessBuilder pb = new ProcessBuilder(curlCommand.split(" "));
        pb.directory(new File(System.getProperty("user.dir")));
        pb.inheritIO();
        Process process = pb.start();
        if (process.waitFor() != 0) {
            System.out.println("L'exécution de la commande curl a échoué");
        }
        process.destroy();
    }
}
