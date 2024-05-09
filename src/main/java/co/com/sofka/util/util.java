package co.com.sofka.util;

import co.com.sofka.model.FormPersonaModel;
import co.com.sofka.model.FormularioModel;
import net.datafaker.Faker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class util {


    public static FormularioModel crearUsuario(){
        FormularioModel formularioModel = new FormularioModel();
        Faker faker = new Faker();
        formularioModel.setFirstName(faker.name().firstName());
        formularioModel.setLastName(faker.name().lastName());
        formularioModel.setMobile(faker.number().digits(10));
        formularioModel.setEmail(faker.internet().emailAddress());
        formularioModel.setBirth(faker.date().birthday());
        formularioModel.setSubjects("Maths");
        formularioModel.setSubjects("Commerce");
        formularioModel.setSubjects("Chemistry");
        formularioModel.setAddress(faker.address().fullAddress());
        formularioModel.setState("Uttar Pradesh");
        formularioModel.setCity("Agra");

        return formularioModel;
    }

    public static Date crearFecha(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Faker faker = new Faker();
        Date fecha =  faker.date().birthday();
        String dateStr = dateFormat.format(fecha);

        // Agregar la hora deseada a la cadena de fecha y hora
        String customDateStr = dateStr.substring(0, 11) + "14:30";

        try {
            // Parsear la cadena de fecha y hora a un objeto Date
            fecha = dateFormat.parse(customDateStr);

            // Imprimir la fecha y hora
            System.out.println(fecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return fecha;
    }

    public static String obtenerNombreMes(Date fecha) {
        SimpleDateFormat formatoMes = new SimpleDateFormat("MMMM", Locale.ENGLISH);
        // Convertir la primera letra a mayúscula
        String nombreMes = formatoMes.format(fecha);
        return nombreMes.substring(0,1).toUpperCase() + nombreMes.substring(1);
    }

    public static String obtenerYear(Date fecha) {
        SimpleDateFormat formatoMes = new SimpleDateFormat("yyyy");
        return formatoMes.format(fecha);
    }

    public static String obtenerDiaSemana(Date fecha) {
        SimpleDateFormat formatoMes = new SimpleDateFormat("EEEE", Locale.ENGLISH);
        String nombreDia = formatoMes.format(fecha);
        return nombreDia.substring(0,1).toUpperCase() + nombreDia.substring(1);
    }

    public static String obtenerOrdinal(int numero) {
            if (numero % 100 >= 11 && numero % 100 <= 13) {
                return numero + "th";
            }
            switch (numero % 10) {
                case 1:
                    return numero + "st";
                case 2:
                    return numero + "nd";
                case 3:
                    return numero + "rd";
                default:
                    return numero + "th";
            }
    }

    public static Date stringToDateResult(String fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("dd MMMM,yyyy", Locale.ENGLISH);
        Date fechaValida;
        // Parsear la cadena a un Date
        try {
             fechaValida =   formato.parse(fecha);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return fechaValida;
    }

    public static Date stringToDate(String fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        Date fechaValida;
        // Parsear la cadena a un Date
        try {
            fechaValida =   formato.parse(fecha);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return fechaValida;
    }


    // Método para calcular el hash MD5
    public static String md5(String text) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(text.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : array) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static boolean compararFechas(Date fecha1, Date fecha2) {
        // Formatear las fechas a cadenas con el formato "yyyy-MM-dd"
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String cadenaFecha1 = formato.format(fecha1);
        String cadenaFecha2 = formato.format(fecha2);

        // Comparar las cadenas de fecha
        return cadenaFecha1.equals(cadenaFecha2);
    }

    public static String convertirArrayListACadena(ArrayList<String> lista) {
        StringBuilder builder = new StringBuilder();

        // Recorrer el ArrayList y concatenar los valores en la cadena
        for (int i = 0; i < lista.size(); i++) {
            builder.append(lista.get(i));
            if (i < lista.size() - 1) {
                builder.append(", "); // Agregar una coma y un espacio entre cada elemento, excepto el último
            }
        }

        return builder.toString();
    }

    public static String obtenerHora(Date fecha) {
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
        // Formatear la fecha y devolver solo la hora en formato de cadena
        return formatoHora.format(fecha);
    }

    public static FormPersonaModel generarFormularioPersonaAleatorio() {
        Faker faker = new Faker();

        String correo = faker.internet().emailAddress();
        String nombre = faker.name().firstName();
        String apellido = faker.name().lastName();
        String numerodoc = "1"+faker.number().digits(9);
        String celular = "3"+faker.number().digits(9);

        return new FormPersonaModel(correo, nombre, apellido, numerodoc, celular);
    }

}
