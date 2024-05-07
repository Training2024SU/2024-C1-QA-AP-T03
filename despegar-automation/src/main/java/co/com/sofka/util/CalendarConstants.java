package co.com.sofka.util;

import java.util.HashMap;
import java.util.Map;

public class CalendarConstants {
    public static Map<Integer, String> months = new HashMap<>();

    static {
        months.put(1, "Enero");
        months.put(2, "Febrero");
        months.put(3, "Marzo");
        months.put(4, "Abril");
        months.put(5, "Mayo");
        months.put(6, "Junio");
        months.put(7, "Julio");
        months.put(8, "Agosto");
        months.put(9, "Septiembre");
        months.put(10, "Octubre");
        months.put(11, "Noviembre");
        months.put(12, "Diciembre");
    }
}
