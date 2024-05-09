package co.com.sofka.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebSetup {

    protected WebDriver driver;


    private void setUpWebDriverUrl(int optionDriver, String url) {
        switch (optionDriver) {
            case 1 -> {
                ChromeOptions optChrome = new ChromeOptions();
                optChrome.addArguments("incognito");
                optChrome.addArguments("disable-notifications");
                driver = new ChromeDriver(optChrome);
            }
            case 2 -> {
                EdgeOptions opt = new EdgeOptions();
                opt.addArguments("disable-notifications");
                opt.addArguments("inprivate");

                driver = new EdgeDriver(opt);
            } case 3 -> {
                driver = new FirefoxDriver();
            }
            default -> {

            }
        }

        driver.get(url);
        /*  maximize();*/

    }

    public void generalSetUp(int op, String url) {
        setUpWebDriverUrl(op, url);
    }

    protected void quiteDriver() {
        driver.quit();
    }

    private void maximize() {
        driver.manage().window().maximize();
    }

}
