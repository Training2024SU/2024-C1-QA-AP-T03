package co.com.prueba.page.despegar;

import co.com.prueba.page.functions.FunctionCommons;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static co.com.prueba.util.ConstantesWait.WAIT_TIME;
import static co.com.prueba.util.ExplicitWaitHelper.*;
import static co.com.prueba.util.ExplicitWaitHelper.waitForElementClickable;

public class PageFactoryLoguinCorreoFallido extends FunctionCommons {

        @CacheLookup
        @FindBy(xpath = "//*[@id='not-logged']/span")
        private WebElement CLICK_INICIO_SESION_1;

        @CacheLookup
        @FindBy(xpath = "//*[@id='not-logged-menu-item']/li[1]/a")
        private WebElement CLICK_INICIO_SESION_2;

        @CacheLookup
        @FindBy(xpath = "//*[@id='root']/div/div/div/div/div/div/div[3]/div[3]/a/em")
        private WebElement ACCEDER_CON_EMAIL;

        @CacheLookup
        @FindBy(id = "input-email")
        private WebElement CAMPO_EMAIL;

        @CacheLookup
        @FindBy(className = "recaptcha-checkbox-border")
        private WebElement RECAPTCHAT;

        @CacheLookup
        @FindBy(xpath = "//*[@id='g-recaptcha- signin']/div/div/iframe")
        private WebElement IFRAME_RECAPTCHAT;

        @CacheLookup
        @FindBy(xpath = "//*[@id='root']/div/div/div/div/div/div/div[4]/div[4]/div/a/em")
        private WebElement BOTON_SIGUIENTE;

        @CacheLookup
        @FindBy(id = "input-password")
        private WebElement CAMPO_PASSWORD;

        public static final String TEXTO_FALLIDO ="//span[text()='Este email no se encuentra registrado en Despegar. Registrate desde']";

    public PageFactoryLoguinCorreoFallido(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void irPaginaInicioSesion() {
            waitForElementPresence(driver, CLICK_INICIO_SESION_1, WAIT_TIME);
            clickSelection(CLICK_INICIO_SESION_1);
            clickSelection(CLICK_INICIO_SESION_2);
            clickSelection(ACCEDER_CON_EMAIL);
        }

        public void ingresarCorreoNoRegistrado() {
            clickSelection(CAMPO_EMAIL);
            typeInto(CAMPO_EMAIL, "osorivarez20@gmail.com");
            waitForElementVisibility(driver, IFRAME_RECAPTCHAT, WAIT_TIME);
            switchToIframe(driver, IFRAME_RECAPTCHAT);
            waitForElementClickable(driver, RECAPTCHAT, WAIT_TIME);
            clickSelection(RECAPTCHAT);
            driver.switchTo().defaultContent();
            scrollTo(BOTON_SIGUIENTE);
        }

        public void confirmarAccion() {
            waitForElementClickable(driver, BOTON_SIGUIENTE, WAIT_TIME);
            clickSelection(BOTON_SIGUIENTE);
            // waitForElementVisibility(driver,CAMPO_PASSWORD, WAIT_TIME);
            //typeInto(CAMPO_PASSWORD,"input-password");
        }
}
