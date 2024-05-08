package co.com.demo.setup;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class WebSetup {

    protected WebDriver driver;

    private void setUpWebDriverUrl(int driverSelection, String url) {
        switch (driverSelection) {
            case 1:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                chromeOptions.addArguments("--no-new-window");
                chromeOptions.addArguments("--disable-popup-blocking"); // Deshabilitar bloqueo de pop-ups
                chromeOptions.addArguments("--incognito");
                driver = new ChromeDriver(chromeOptions);
                break;
            case 2:
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Invalid driver selection");
        }

        driver.get(url);
        maximizeWindow();
    }

    protected void generalSetUp(int driverType, String url) {
        setUpWebDriverUrl(driverType, url);
    }

    protected void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void maximizeWindow() {
        driver.manage().window().maximize();
    }
}
