package co.com.sofka.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class WebSetup {
    private static final String DEMO_QA_URL = "https://zonafit.co/";

    protected static WebDriver driver;

    private void setUpWebDriverUrl(int driverSelect) {
        switch (driverSelect) {
            case 1:
                ChromeOptions co = new ChromeOptions();
                co.addArguments("--remote-allow-origins=*");
                co.addArguments("--incognito");
                co.addArguments("disable-notifications");
                driver = new ChromeDriver(co);
                break;
            case 2:
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("ingrese un numero valido");
        }
        driver.get(DEMO_QA_URL);
        maximize();
    }

    protected void generalSetUp(int tipoDriver) {
        setUpWebDriverUrl(tipoDriver);
    }

    protected void quiteDriver() {
        driver.quit();
    }

    private void maximize() {
        driver.manage().window().maximize();
    }
}
