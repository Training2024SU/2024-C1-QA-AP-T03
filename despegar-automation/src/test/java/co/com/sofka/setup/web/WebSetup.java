package co.com.sofka.setup.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;


public class WebSetup {
    private static final String DESPEGAR_URL = "https://www.despegar.com.co/";
    private static final String EXITO_URL = "https://www.exito.com/";

    protected static WebDriver driver;

    private void setupWebDriverUrl(WebBrowser webBrowser, WebPage webPage) {
        switch (webBrowser) {
            case CHROME -> chromeConfiguration(webPage);
            case EDGE -> edgeConfiguration(webPage);
            default -> throw new IllegalArgumentException("Enter a valid option");
        }
    }

    private void edgeConfiguration(WebPage webPage) {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setCapability("ms:inPrivate", true);
        edgeOptions.setCapability("ms:edgeChromium", true);
        edgeOptions.setCapability("ms:edgeOptions", "--headless");
        driver = new EdgeDriver(edgeOptions);
        configureBrowser(webPage);
    }

    private void configureBrowser(WebPage webPage) {
        switch (webPage){
            case DESPEGAR:
                driver.get(DESPEGAR_URL);
                break;
            case EXITO:
                driver.get(EXITO_URL);
                break;
        }
        maximizeWindow();
    }

    private void chromeConfiguration(WebPage webPage) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-notifications");
        driver = new ChromeDriver(chromeOptions);
        configureBrowser(webPage);
    }

    protected void generalSetup(WebBrowser webBrowser, WebPage webPage) {
        setupWebDriverUrl(webBrowser, webPage);
    }

    protected void quitDriver() {
        driver.quit();
    }

    private void maximizeWindow() {
        driver.manage().window().maximize();
    }

}
