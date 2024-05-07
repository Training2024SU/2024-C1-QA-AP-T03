package co.com.sofkau.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
public class WebSetup {
    private static final String ZONA_FIT_URL = "https://zonafit.co/";
    protected static WebDriver driver;

    private void setUpWebdriverUrl(int driverSelect){
        switch (driverSelect) {
            case 1:
                ChromeOptions co = new ChromeOptions();
                co.addArguments("--remote-allow-origins=*");
                co.addArguments("--incognito");
                co.addArguments("--disable-notifications");
                driver = new ChromeDriver(co);
                break;
            case 2:
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Ingrese una opcion valida");
        }
        driver.get(ZONA_FIT_URL);
        maximize();

    }
    protected void generalSetUp(int tipoDriver){
        setUpWebdriverUrl(tipoDriver);
    }

    protected void quiteDriver(){
        driver.quit();
    }

    private void maximize(){
        driver.manage().window().maximize();
    }

    public void navegarA(String pagina){
        driver.get(pagina);
    }
}
