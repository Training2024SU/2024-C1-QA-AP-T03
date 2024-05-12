package co.com.prueba.page.despegar;

import co.com.prueba.page.functions.FunctionCommons;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static co.com.prueba.util.ConstantesWait.WAIT_TIME;
import static co.com.prueba.util.ExplicitWaitHelper.waitForElementClickable;
import static co.com.prueba.util.ExplicitWaitHelper.waitForElementVisibility;

public class PageFactoryRegistro extends FunctionCommons {

    @CacheLookup
    @FindBy(xpath = "//*[@id='not-logged']/span")
    private WebElement CLICK_INICIO_SESION_1;
    @CacheLookup
    @FindBy(xpath = "//*[@id='not-logged-menu-item']/li[1]/a")
    private WebElement CLICK_INICIO_SESION_2;
    @CacheLookup
    @FindBy(xpath = "//em[text()='Registrate']")
    private WebElement BOTON_REGISTRATE;
    @CacheLookup
    @FindBy(xpath = "//em[text()='Registrarse con un email']")
    private WebElement BOTON_REGISTRATE_CON_EMAIL;
    @CacheLookup
    @FindBy(id = "input-email")
    private WebElement CAMPO_EMAIL;
    @CacheLookup
    @FindBy(xpath = "//*[@id='recaptcha-anchor']/div[1]")
    private WebElement CAMPO_RECAPTCHA;
    @CacheLookup
    @FindBy(xpath = "//*[@id='g-recaptcha-signup']/div/div/iframe")
    private WebElement IFRAME_RECAPTCHAT_REGISTRO;
    @CacheLookup
    @FindBy(xpath = "//em[text()='Siguiente']")
    private WebElement BOTON_SIGUIENTE;
    @CacheLookup
    @FindBy(id = "input-password")
    private WebElement CAMPO_CONTRASENIA;
    @CacheLookup
    @FindBy(xpath = "//em[text()='Crear una cuenta']")
    private WebElement BOTON_CREAR_UNA_CUENTA;
    @CacheLookup
    @FindBy(xpath = "//span[text()='Este campo es requerido']")//cuando intenta registrar con el campo contraseña vacion
    private WebElement TEXT_CAMPO_REQUERIDO;

    public PageFactoryRegistro(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void irRegistro() {
        // waitForElementPresence(driver, CLICK_INICIO_SESION_1, WAIT_TIME);
        clickSelection(CLICK_INICIO_SESION_1);
        clickSelection(CLICK_INICIO_SESION_2);
        clickSelection(BOTON_REGISTRATE);
        clickSelection(BOTON_REGISTRATE_CON_EMAIL);
    }

    public void continuarRegistro() {
        // waitForElementPresence(driver, CLICK_INICIO_SESION_1, WAIT_TIME);
        waitForElementVisibility(driver, IFRAME_RECAPTCHAT_REGISTRO, WAIT_TIME);
        switchToIframe(driver, IFRAME_RECAPTCHAT_REGISTRO);
        waitForElementClickable(driver, CAMPO_RECAPTCHA, WAIT_TIME);
        clickSelection(CAMPO_RECAPTCHA);
        driver.switchTo().defaultContent();
        scrollTo(BOTON_SIGUIENTE);
        clickSelection(BOTON_SIGUIENTE);
    }
}
