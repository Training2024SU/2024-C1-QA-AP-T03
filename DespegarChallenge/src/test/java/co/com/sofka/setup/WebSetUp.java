package co.com.sofka.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebSetUp {
    private static final String DESPEGAR_URL_HOME ="https://www.despegar.com.co/";
    public static WebDriver driver;
    private void setUpWebDriverUrl(int driverSelect){
        switch (driverSelect){
            case 1:
                ChromeOptions co=new ChromeOptions();
                co.addArguments("--incognito");
                co.addArguments("--disable-notifications");
                driver = new ChromeDriver(co);
                break;
            case 2:
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("-private");
                driver = new FirefoxDriver(options);
                break;
            default:
                System.out.println("Enter a valid option");
        }
        driver.get(DESPEGAR_URL_HOME);
        maximize();
    }
    protected void generalSetUp(int driverType){
        setUpWebDriverUrl(driverType);
    }
    protected void quiteDriver(){
        driver.quit();
    }
    private void maximize(){
        driver.manage().window().maximize();
    }
}
