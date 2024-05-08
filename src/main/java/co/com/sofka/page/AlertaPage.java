package co.com.sofka.page;

import co.com.sofka.util.functions.FunctionsCommon;
import io.cucumber.messages.internal.com.google.protobuf.Message;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertaPage extends FunctionsCommon {
    public AlertaPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // localizadores

    @CacheLookup
    @FindBy(id = "alertButton")
    private WebElement ALERT_BUTTON;

    @CacheLookup
    @FindBy(id = "timerAlertButton")
    private WebElement TIMER_ALERT;

    @CacheLookup
    @FindBy(id = "confirmButton")
    private WebElement ALERT_CANCELATION_BUTTON;

    @CacheLookup
    @FindBy(id = "promtButton")
    private WebElement ALERT_PROM;

    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public void dispararAlerta() {
        clickSelection(ALERT_BUTTON);
        aceptarAlerta();
    }

    public void dispararTimeAlert() {
        clickSelection(TIMER_ALERT);
        aceptarTimeAlert();
    }

    public void dispararAlertCancelationButton() {
        scrollTo(ALERT_CANCELATION_BUTTON);
        clickSelection(ALERT_CANCELATION_BUTTON);
        aceptarAlertCancelationButton();
    }

    public void dispararPromtButton(String mesagge) {
        clickSelection(ALERT_PROM);
        if (mesagge.equals(driver.switchTo().alert().getText())) {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.sendKeys("Mi nombre es Máximo Décimo Meridio, comandante de los ejércitos del norte, general de las Legiones Fénix, fiel servidor del verdadero emperador Marco Aurelio. Padre de un hijo asesinado, esposo de una esposa asesinada y juro que me vengaré, en esta vida o en la otra");
            alert.accept();
        }
    }

    public void aceptarAlerta() {
        driver.switchTo().alert().accept();
    }

    public void aceptarTimeAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public void aceptarAlertCancelationButton() {
//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        driver.switchTo().alert().dismiss();
    }

    public void aceptarPromtButton(String mesagge) {
//        wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(mesagge);
        System.out.println(driver.switchTo().alert().getText());

        if (mesagge.equals(driver.switchTo().alert().getText())) {
            driver.switchTo().alert().sendKeys("Mi nombre es Máximo Décimo Meridio, comandante de los ejércitos del norte, general de las Legiones Fénix, fiel servidor del verdadero emperador Marco Aurelio. Padre de un hijo asesinado, esposo de una esposa asesinada y juro que me vengaré, en esta vida o en la otra");
        }
    }


}
