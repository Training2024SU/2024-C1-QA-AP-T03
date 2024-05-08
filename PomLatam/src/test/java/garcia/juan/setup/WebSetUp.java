package garcia.juan.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class WebSetUp {
    private static final String LATAM_URL ="https://www.latamairlines.com";

    protected static WebDriver driver;

    private void setUpWebDriverUrl(int driverSelection){

        switch (driverSelection){
            case 1:
                driver = new EdgeDriver();
                driver.get(LATAM_URL);
                maximize();
                break;
            case 2:
                ChromeOptions co = new ChromeOptions();
                co.addArguments("--remote-allow-origins=*");
                co.addArguments("--incognito");
                co.addArguments("--disable-notifications");
                driver = new ChromeDriver(co);
                driver.get(LATAM_URL);
                maximize();
                break;
        }

    }
    protected void generalSetUp(int navegador){
        setUpWebDriverUrl(navegador);
    }

    protected void quiteDriver(){
        driver.quit();
    }

    protected void maximize(){
        driver.manage().window().maximize();
    }
}
