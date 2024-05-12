package co.com.prueba.util;

import co.com.prueba.model.FormularioModel;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class Util {
    public static FormularioModel crearUsuario() {
        Faker faker = new Faker(new Locale("es"));
        String nombre = faker.name().firstName();
        String apellido = faker.name().lastName();
        String celular = "3" + faker.number().digits(9);
        String correo = "correobueno@example.com" ;
        //nombre + apellido + "@example.com";
        String subjet = faker.hobbit().character();
        String nombreCalle = faker.address().streetName();
        String numeroCalle = faker.address().buildingNumber();
        String ciudad = faker.address().city();
        String direccion = nombreCalle + " " + numeroCalle + ", " + ciudad;
        FormularioModel form = new FormularioModel();
        form.setNombre(nombre);
        form.setApellido(apellido);
        form.setNumeroCelular(celular);
        form.setCorreo(correo);
        form.setDireccion(direccion);
        return form;
    }



    public static void dragAndDrop(WebDriver driver, By fromLocator, By toLocator) {
        // Localizar los elementos de origen y destino
        WebElement fromElement = driver.findElement(fromLocator);
        WebElement toElement = driver.findElement(toLocator);
        // Crear una instancia de la clase Actions
        Actions actions = new Actions(driver);
        // Hacer click y mantener en el elemento de origen, y luego moverlo al elemento de destino
        actions.clickAndHold(fromElement).moveToElement(toElement).release().build().perform();
    }

    public static void waitForDraggableElement(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Espera hasta 10 segundos
        WebElement draggableElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("draggable")));
    }

    public static String generarFecha(){
        Calendar calendar = Calendar.getInstance();
        int year = getRandomNumber(2004, 2024);
        int month = getRandomNumber(0, 11);
        int day = getRandomNumber(1, 28);
        calendar.set(year, month, day);
        Date fechaAleatoria = calendar.getTime();
        SimpleDateFormat formato = new SimpleDateFormat("MM/dd/yyyy");
        String fechaFormateada = formato.format(fechaAleatoria);
        return fechaFormateada;
    }
    private static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

}

