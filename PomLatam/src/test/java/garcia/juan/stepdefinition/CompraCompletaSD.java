package garcia.juan.stepdefinition;

import garcia.juan.page.*;
import garcia.juan.setup.WebSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class CompraCompletaSD extends WebSetUp {

    MainPage mainPage;
    VuelosDisponiblesPage vuelosDisponiblesPage;
    EquipajePage equipajePage;
    PasajeroFormPage pasajeroFormPage;
    MetodoPagoPage metodoPagoPage;

    private String origen, destino, fecha1, fecha2;

    @Given("el usuario se encuentra en la pagina de inicio de Latam en el navegador {int}")
    public void el_usuario_se_encuentra_en_la_pagina_de_inicio_de_latam(int navegador) {
        generalSetUp(navegador);
        mainPage = new MainPage(driver);
        try{
            mainPage.quedarseColombia();
            mainPage.acceptCookies();

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
            mainPage.realizaBusqueda();
            switchToNewTab();
            vuelosDisponiblesPage = new VuelosDisponiblesPage(driver);
            vuelosDisponiblesPage.clickVueloRecomendado();
            vuelosDisponiblesPage.clickVueloRecomendado2();
            vuelosDisponiblesPage.irAAsientos();
            vuelosDisponiblesPage.pasarAlsiguienteAsientos();
            vuelosDisponiblesPage.ignorarAsientos();
            equipajePage = new EquipajePage(driver);
            equipajePage.continuarSinEquipaje();
        } catch (Exception e){
            System.out.println(e.getMessage());
            quiteDriver();
            Assertions.fail();
        }
    }

    @When("diligencia el formulario de los {int} pasajeros")
    public void diligenciaElFormularioDeLosPasajeros(int int1,io.cucumber.datatable.DataTable dataTable) {
        try {
            pasajeroFormPage = new PasajeroFormPage(driver);
            pasajeroFormPage.llenarFormulario(int1,dataTable);
            pasajeroFormPage.pasarAPago();

        }catch (Exception e){
            System.out.println(e.getMessage());
            quiteDriver();
            Assertions.fail();
        }
    }
    @When("inserta su metodo de pago")
    public void insertaSuMetodoDePago(io.cucumber.datatable.DataTable dataTable) {
        try {
            metodoPagoPage=new MetodoPagoPage(driver);
            metodoPagoPage.seleccionarTarjeta(dataTable);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            quiteDriver();
            Assertions.fail();
        }
    }
    @Then("deberia recibir el mensaje de que su reserva fue completada la información respectiva")
    public void deberiaRecibirElMensajeDeQueSuReservaFueCompletadaLaInformaciónRespectiva() throws InterruptedException {
        Thread.sleep(10000); //para ver como termina
        quiteDriver();
    }

}
