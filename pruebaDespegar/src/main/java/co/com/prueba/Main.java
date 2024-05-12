package co.com.prueba;

import com.github.javafaker.Faker;


public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker();

        // Generar un número de teléfono celular colombiano ficticio de 10 dígitos sin separadores
        StringBuilder numeroCelularBuilder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            numeroCelularBuilder.append(faker.number().numberBetween(0, 9)); // Generar un dígito aleatorio
        }
        String numeroCelular = numeroCelularBuilder.toString();

        // Imprimir el número de teléfono celular generado
        System.out.println("Número de celular colombiano generado: " + "30"+numeroCelular);
    }
}





