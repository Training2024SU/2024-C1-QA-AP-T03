package co.com.sofka.setup.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;


public class WebSetup {
    private static final String DESPEGAR_URL = "https://www.despegar.com.co/";
    protected static WebDriver driver;

    private void setupWebDriverUrl(WebBrowser webBrowser) {
        switch (webBrowser) {
            case CHROME -> chromeConfiguration();
            case EDGE -> edgeConfiguration();
            default -> System.out.println("Enter a valid option");
        }
    }

    private void edgeConfiguration() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setCapability("ms:inPrivate", true);
        edgeOptions.setCapability("ms:edgeChromium", true);
        edgeOptions.setCapability("ms:edgeOptions", "--headless");
        driver = new EdgeDriver(edgeOptions);
        configureBrowser();
    }

    private void configureBrowser() {
        driver.get(DESPEGAR_URL);
        maximizeWindow();
    }

    private void chromeConfiguration() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-notifications");
////        chromeOptions.addArguments("--headless");
//        chromeOptions.addArguments("--use_subprocess");
        driver = new ChromeDriver(chromeOptions);
        configureBrowser();
    }

    protected void generalSetup(WebBrowser webBrowser) {
        setupWebDriverUrl(webBrowser);
    }

    protected void quiteDrive() {
        driver.quit();
    }

    private void maximizeWindow() {
        driver.manage().window().maximize();
    }

}
