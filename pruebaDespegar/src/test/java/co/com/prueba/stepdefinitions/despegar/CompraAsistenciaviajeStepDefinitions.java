package co.com.prueba.stepdefinitions.despegar;

import co.com.prueba.page.despegar.PageFactoryAsistenciaViaje;
import co.com.prueba.setup.WebSetup;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

public class CompraAsistenciaviajeStepDefinitions extends WebSetup {
    PageFactoryAsistenciaViaje asistenciaViaje;

    @Dado("que el usuario esta en la pagina de asistencia")
    public void queElUsuarioEstaEnLaPaginaDeAsistencia() {
        //generalSetup();
    }

    @Cuando("completa todos los campos con informacion valida")
    public void completaTodosLosCamposConInformacionValida() {
        asistenciaViaje = new PageFactoryAsistenciaViaje(driver);
        asistenciaViaje.llenarCampos();
    }

    @Cuando("elije la opcion que desea comprar")
    public void elijeLaOpcionQueDeseaComprar() {
        asistenciaViaje = new PageFactoryAsistenciaViaje(driver);
        asistenciaViaje.elegirOpcionCompra();
    }

    @Entonces("deberia ser dirigido a la opcion de pago")
    public void deberiaSerDirigidoALaOpcionDePago() {
    }
}
