package co.com.prueba.stepdefinitions.despegar;

import co.com.prueba.page.despegar.PageFactoryLoguinCorreoFallido;
import co.com.prueba.setup.WebSetup;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.openqa.selenium.By;

import static co.com.prueba.page.despegar.PageFactoryLoguinCorreoFallido.TEXTO_FALLIDO;
import static co.com.prueba.util.ConstantStepDefinitions.EXPECTED_ERROR_MESSAGE;

public class LoguinCorreoNoRegistradoStepDefinitions extends WebSetup {

    PageFactoryLoguinCorreoFallido pageFactoryLoguin;

    @Dado("Given que el usuario esta en la página de inicio de sesión")
    public void givenQueElUsuarioEstaEnLaPáginaDeInicioDeSesión() {
        try {
           // generalSetup();
            pageFactoryLoguin = new PageFactoryLoguinCorreoFallido(driver);
            pageFactoryLoguin.irPaginaInicioSesion();
        }catch (Exception e) {
            System.out.println(e.getMessage());
            //quiteDriver();
        }
    }
    @Cuando("ingresa un correo no registrado")
    public void ingresaUnCorreoNoRegistrado() {
        pageFactoryLoguin = new PageFactoryLoguinCorreoFallido(driver);
        pageFactoryLoguin.ingresarCorreoNoRegistrado();
    }
    @Cuando("confirmar la accion")
    public void confirmarLaAccion() {
        pageFactoryLoguin = new PageFactoryLoguinCorreoFallido(driver);
        pageFactoryLoguin.confirmarAccion();
    }
    @Entonces("deberia ver un mensaje de error")
    public void deberiaVerUnMensajeDeError() {
        String actualErrorMessage = driver.findElement(By.xpath(TEXTO_FALLIDO)).getText();
        assert actualErrorMessage.equals(EXPECTED_ERROR_MESSAGE);
    }
}
