package co.com.prueba.stepdefinitions.despegar;

import co.com.prueba.page.despegar.PageFactoryRegistro;
import co.com.prueba.setup.WebSetup;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.openqa.selenium.By;

import static co.com.prueba.page.despegar.PageFactoryConstant.CONTRASENIA;
import static co.com.prueba.page.despegar.PageFactoryConstant.CORREO;

public class RegistroOutlineStepDefinitions extends WebSetup {
    PageFactoryRegistro pageFactoryRegistro;

    @Dado("Given que el usuario se encuentra en la página de registro")
    public void givenQueElUsuarioSeEncuentraEnLaPáginaDeRegistro() {
       // generalSetup();
        pageFactoryRegistro = new PageFactoryRegistro(driver);
        pageFactoryRegistro.irRegistro();
    }

    @Cuando("Cuando se registra con correo {string} y contrasenia {string}")
    public void cuandoSeRegistraConCorreoYContrasenia(String correo, String contrasenia) {
        pageFactoryRegistro = new PageFactoryRegistro(driver);
        pageFactoryRegistro.continuarRegistro();
        driver.findElement(By.id(CORREO)).sendKeys(correo);
        pageFactoryRegistro.continuarRegistro();
        driver.findElement(By.id(CONTRASENIA)).sendKeys(contrasenia);
    }

    @Cuando("continua con la accion")
    public void continuaConLaAccion() {

    }

    @Entonces("debería recibir un mensaje de confirmación al correo")
    public void deberíaRecibirUnMensajeDeConfirmaciónAlCorreo() {
        // quiteDriver();
    }
}
