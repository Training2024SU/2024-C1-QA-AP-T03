package co.com.sofka.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebSetup {

    protected WebDriver driver;


    private void setUpWebDriverUrl(String optionDriver, String url) {
        switch (optionDriver) {
            case "Chrome" -> {
                ChromeOptions optChrome = new ChromeOptions();
                optChrome.addArguments("incognito");
                optChrome.addArguments("disable-notifications");
                driver = new ChromeDriver(optChrome);
            }
            case "Edge" -> {
                EdgeOptions opt = new EdgeOptions();
                opt.addArguments("disable-notifications");
                opt.addArguments("inprivate");

                driver = new EdgeDriver(opt);
            }
            default -> {

            }
        }

        driver.get(url);
//        maximize();

    }

    public void generalSetUp(String op, String url) {
        setUpWebDriverUrl(op, url);
    }

    protected void quiteDriver() {
        driver.quit();
    }

    private void maximize() {
        driver.manage().window().maximize();
    }

}
