package co.com.prueba.setup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;

import static co.com.prueba.page.exitopage.constantexitopage.ConstansExitoPage.OPTION_INVALID;

public class WebSetup {

    private static final String DESPEGAR_QA_URL = "https://www.despegar.com.co/home/root";

    private static final String EXITO_URL = "https://www.exito.com/";

/*
    public static WebDriver driver;

    private void setUpWebdriverUrl() {
        ChromeOptions options = new ChromeOptions();
        //EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        // driver = new EdgeDriver(options);
        driver = new ChromeDriver(options);
        driver.get(DESPEGAR_QA_URL);
        //driver.get(EXITO_URL);
        maximize();
    }

    public void generalSetup() {
        setUpWebdriverUrl();
    }

    public void quiteDriver() {
        driver.quit();
    }

    private void maximize() {
        driver.manage().window().maximize();
    }

 */



    protected static WebDriver driver;

    private void setupWebDriverUrl(int driverSelect) {
        switch (driverSelect) {
            case 1:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--incognito");
                chromeOptions.addArguments("--disable-notifications");
                driver = new ChromeDriver(chromeOptions);
                break;
            case 2:
                edgeConfiguration();
                break;
            case 3:
                firefoxConfiguration();
            default:
                System.out.println(OPTION_INVALID);
        }
        driver.get(EXITO_URL);
        maximize();
    }

    private void firefoxConfiguration() {
        FirefoxOptions fo = new FirefoxOptions();
        fo.addArguments("-private");
        fo.addPreference("extensions.allowPrivateBrowsingByDefault", true);
        FirefoxProfile fp = new FirefoxProfile();
        fp.setPreference("browser.privatebrowsing.autostart", true);
        fo.setProfile(fp);
//                fo.addArguments("-headless");
        driver = new FirefoxDriver(fo);
    }

    private void edgeConfiguration() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setCapability("ms:inPrivate", true);
        edgeOptions.setCapability("ms:edgeChromium", true);
        edgeOptions.setCapability("ms:edgeOptions", "--headless");
        driver = new EdgeDriver(edgeOptions);
    }

    protected void generalSetup(int tipoDriver) {
        setupWebDriverUrl(tipoDriver);
    }

    protected void quiteDrive() {
        driver.quit();
    }

    private void maximize() {
        driver.manage().window().maximize();
    }

}
