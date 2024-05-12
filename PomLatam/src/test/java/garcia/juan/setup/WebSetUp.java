package garcia.juan.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class WebSetUp {
    private static final String LATAM_URL ="https://www.latamairlines.com/co/es";

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

    protected void switchToNewTab() {
        String mainWindowHandle = driver.getWindowHandle();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        Set<String> allWindowHandles = driver.getWindowHandles();

        String newWindowHandle = "";
        for (String handle : allWindowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                newWindowHandle = handle;
                break;
            }
        }
        driver.switchTo().window(newWindowHandle);
    }
}
