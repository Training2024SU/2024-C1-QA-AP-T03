package co.com.prueba.util;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertsHelper {
    public  WebDriver driver;
    public  WebDriverWait wait;

    public AlertsHelper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public  void esperarYCerrarAlerta() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public static void acceptAlert(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void esperarAceptarAlertaConTexto(String texto) {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(texto);
        alert.accept(); // O puedes usar alert.dismiss() si deseas cancelar la acción
    }
}
