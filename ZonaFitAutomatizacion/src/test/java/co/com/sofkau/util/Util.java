package co.com.sofkau.util;

import co.com.sofkau.model.FormularioFacturacionYEnvioModel;
import com.github.javafaker.Faker;

public class Util {
        public static FormularioFacturacionYEnvioModel crearUsuario() {
        Faker faker = new Faker();

        FormularioFacturacionYEnvioModel formularioFacturacionYEnvioModel = new FormularioFacturacionYEnvioModel();

        formularioFacturacionYEnvioModel.setNombre(faker.name().firstName());
        formularioFacturacionYEnvioModel.setApellido(faker.name().lastName());
        formularioFacturacionYEnvioModel.setNumeroDocumento(faker.numerify("##########"));
        formularioFacturacionYEnvioModel.setEmail(faker.internet().emailAddress());
        formularioFacturacionYEnvioModel.setDireccion(faker.address().fullAddress());
        formularioFacturacionYEnvioModel.setNumeroCelular(generarNumeroCelularColombiano(faker));

        return formularioFacturacionYEnvioModel;
    }

        // Para generar números de celulares colombianos válidos con faker
        public static String generarNumeroCelularColombiano(Faker faker) {
                String[] prefixes = {"300", "301", "302", "303", "304", "305", "310", "311", "312", "313", "314", "315", "316", "317", "318", "320", "321", "322", "323", "350"}; // Prefijos de operadores colombianos
                String prefijosRandom = prefixes[faker.number().numberBetween(0, prefixes.length)];
                String number = faker.numerify("#######"); // 7 dígitos aleatorios

                return prefijosRandom + number;
        }
}
