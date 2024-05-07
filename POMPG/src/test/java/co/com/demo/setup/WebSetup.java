package co.com.demo.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class WebSetup {

    protected WebDriver driver;

    private void setUpWebDriverUrl(int driverSelection, String url){
        switch (driverSelection){
            case 1:
                ChromeOptions co = new ChromeOptions();
                driver = new ChromeDriver(co);
                break;
            case 2:
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Enter a valid option");
        }

        driver.get(url);
        maximize();
    }

    protected void generalSetUp(int tipoDriver, String url){
        setUpWebDriverUrl(tipoDriver, url);
    }

    protected void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void maximize (){
        driver.manage().window().maximize();
    }
}

