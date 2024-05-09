package co.com.demo.setup;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class WebSetup {

    protected WebDriver driver;

    private void setUpWebDriverUrl(int driverSelection, String url) {
        switch (driverSelection) {
            case 1:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                chromeOptions.addArguments("--no-new-window");
                chromeOptions.addArguments("--disable-popup-blocking");
                chromeOptions.addArguments("--incognito");
                chromeOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS);
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
