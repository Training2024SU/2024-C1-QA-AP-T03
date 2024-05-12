package co.com.sofka.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import static co.com.sofka.constant.Urls.URL_ZONAFIT;

public class WebSetup {

    private static final String DEMO_SORTABLE_URL = "https://demoqa.com/sortable";

    protected WebDriver driver;

    protected String definirPagina() {
        return URL_ZONAFIT;
    }

    protected void setUpWebdriverUrl(int driverSelect) {
        switch (driverSelect) {
            case 1:
                ChromeOptions co = new ChromeOptions();
                co.addArguments("--incognito");
                co.addArguments("--disable-notifications");
                driver = new ChromeDriver(co);
                break;
            case 2:
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--incognito");
                driver = new EdgeDriver(edgeOptions);
                break;
            case 3:
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("ingrese una opcion valida");
        }
        abrirPagina(definirPagina());
        maximize();
    }

    protected void sortableSetUp() {
        driver = new EdgeDriver();
        driver.get(DEMO_SORTABLE_URL);
        maximize();
    }

    protected void abrirPagina(String page) {
        driver.get(page);
    }

    protected void quitDriver() {
        driver.quit();
    }

    private void maximize() {
        driver.manage().window().maximize();
    }
}