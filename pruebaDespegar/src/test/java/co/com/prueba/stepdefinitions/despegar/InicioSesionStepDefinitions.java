package co.com.prueba.stepdefinitions.despegar;

import co.com.prueba.page.despegar.PageFactoryLoguin;
import co.com.prueba.setup.WebSetup;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

public class InicioSesionStepDefinitions extends WebSetup {
    PageFactoryLoguin pageFactoryLoguin;
    @Dado("Given que el usuario esta en la página de inicio de sesión de Despegar.com")
    public void givenQueElUsuarioEstaEnLaPáginaDeInicioDeSesiónDeDespegarCom() {
        try {
           // generalSetup();
            pageFactoryLoguin = new PageFactoryLoguin(driver);
            pageFactoryLoguin.irPaginaInicioSesion();
        }catch (Exception e) {
            System.out.println(e.getMessage());
            //quiteDriver();
        }
    }
    @Cuando("ingresa los credenciales correctamente")
    public void ingresaLosCredencialesCorrectamente() {
        try {
            pageFactoryLoguin = new PageFactoryLoguin(driver);
            pageFactoryLoguin.llenarCamposLoguin();
        }catch (Exception e) {
            System.out.println(e.getMessage());
            //quiteDriver();
        }

    }
    @Cuando("procede a confirmar la accion")
    public void procedeAConfirmarLaAccion() {
        pageFactoryLoguin = new PageFactoryLoguin(driver);
        pageFactoryLoguin.confirmarAccion();
    }
    @Entonces("deberia ser dirigido a la pagina principal del inicio de sesion")
    public void deberiaSerDirigidoALaPaginaPrincipalDelInicioDeSesion() {
    }
}
