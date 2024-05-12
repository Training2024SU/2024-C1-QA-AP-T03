package co.com.prueba.stepdefinitions.despegar;

import co.com.prueba.page.despegar.PageFactoryAsistenciaViaje;
import co.com.prueba.setup.WebSetup;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.openqa.selenium.By;

public class FormAsistenciaViajeStepDefinitions extends WebSetup {
    PageFactoryAsistenciaViaje asistenciaViaje;
    @Dado("que el usuario esta en la pagina de finalizacion de compra")
    public void queElUsuarioEstaEnLaPaginaDeFinalizacionDeCompra() {
        //generalSetup();
        asistenciaViaje = new PageFactoryAsistenciaViaje(driver);
        asistenciaViaje.llenarCampos();
    }
    @Cuando("llena el formulario con los datos {string}, {string}, {string} y {string}")
    public void llenaElFormularioConLosDatosY(String nombre, String apellido, String correo, String telefono) {
        driver.findElement(By.id("yql9co0fcos4jbf37krb2n")).sendKeys(nombre);
        driver.findElement(By.id("ue812hbbzisgi4c5igh3hm")).sendKeys(apellido);
        driver.findElement(By.id("formData.contactData.mainEmailAddress")).sendKeys(correo);
        driver.findElement(By.id("formData.contactData.repeatMainEmailAddress")).sendKeys(correo);
        driver.findElement(By.id("formData.contactData.phones[0].number")).sendKeys(telefono);
    }
    @Cuando("el usuario continua con la finalizacion de la compra")
    public void elUsuarioContinuaConLaFinalizacionDeLaCompra() {
    }
    @Entonces("deberia finalizar la compra exitosamente")
    public void deberiaFinalizarLaCompraExitosamente() {
    }
}
