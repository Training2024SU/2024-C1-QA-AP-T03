package garcia.juan.stepdefinition;

import garcia.juan.page.MainPage;
import garcia.juan.page.VuelosDisponiblesPage;
import garcia.juan.setup.WebSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class CompraCompletaSD extends WebSetUp {

    MainPage mainPage;
    VuelosDisponiblesPage vuelosDisponiblesPage;

    private String origen, destino, fecha1, fecha2;

    @Given("el usuario se encuentra en la pagina de inicio de Latam")
    public void el_usuario_se_encuentra_en_la_pagina_de_inicio_de_latam() {
        generalSetUp(2);
        mainPage = new MainPage(driver);
        try{
            mainPage.quedarseColombia();
            mainPage.acceptCookies();
            Thread.sleep(2000);
        } catch (Exception e){
            System.out.println(e.getMessage());
            Assertions.fail();
        }
    }

    @When("busca el vuelo sin seleccionar adicionales")
    public void buscaUnElVueloSinSeleccionarAdicionales(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
        origen = dataTable.cell(1,0);
        destino = dataTable.cell(1,1);
        fecha1 = dataTable.cell(1, 2);
        fecha2 = dataTable.cell(1,3);

        try{
            mainPage.insertOrigenAndDestino(origen,destino);
            mainPage.buscarFecha(fecha1,fecha2);
        } catch (Exception e){
            System.out.println(e.getMessage());
            quiteDriver();
            Assertions.fail();
        }
        Thread.sleep(2000);
        mainPage.realizaBusqueda();

        Thread.sleep(8000);
        vuelosDisponiblesPage = new VuelosDisponiblesPage(driver);
        vuelosDisponiblesPage.clickVueloRecomendado();

    }

    @When("diligencia el formulario de los pasajeros")
    public void diligenciaElFormularioDeLosPasajeros() {

    }
    @When("inserta su metodo de pago")
    public void insertaSuMetodoDePago() {

    }
    @Then("deberia recibir el mensaje de que su reserva fue completada la información respectiva")
    public void deberiaRecibirElMensajeDeQueSuReservaFueCompletadaLaInformaciónRespectiva() throws InterruptedException {
        Thread.sleep(2000);
        quiteDriver();
    }

}
