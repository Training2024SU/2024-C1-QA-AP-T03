package co.com.prueba.stepdefinitions.despegar;

import co.com.prueba.page.despegar.PageFactoryTraslado;
import co.com.prueba.setup.WebSetup;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.openqa.selenium.By;

import static co.com.prueba.page.despegar.PageFactoryTraslado.MENSAJE_ERROR;
import static co.com.prueba.util.ConstantStepDefinitions.*;

public class BuscarTrasladoStepDefinitions extends WebSetup {
    PageFactoryTraslado traslado;
    @Dado("que el usuario esta en la pagina de traslado")
    public void queElUsuarioEstaEnLaPaginaDeTraslado() {
        //generalSetup();
    }
    @Cuando("ingresa informacion en los campos incompleta")
    public void ingresaInformacionEnLosCamposIncompleta() {
        traslado = new PageFactoryTraslado(driver);
        traslado.llenarCampos();
    }
    @Cuando("prosigue con la accion")
    public void prosigueConLaAccion() {
        traslado = new PageFactoryTraslado(driver);
        traslado.continuarAccion();
    }
    @Entonces("deberia ver un mensaje error indicando que complete la informacion")
    public void deberiaVerUnMensajeErrorIndicandoQueCompleteLaInformacion() {
        String actualErrorMessage = driver.findElement(By.xpath(MENSAJE_ERROR)).getText();
        assert actualErrorMessage.equals(EXPECTED_MESSAGE);
        System.out.println("el mensaje: "+ actualErrorMessage+" Es igual a: "+EXPECTED_MESSAGE);
        quiteDrive();
    }
}
