package co.com.sofka.setup;

import static co.com.sofka.constant.Constants.GET_ESTADO;
import static co.com.sofka.constant.Constants.GET_FECHA;

public class CommonFunctions {
    public String obtenerTodoPorEstado(String estado) {
        return String.format(GET_ESTADO, estado);
    }

    public String obtenerTodoPorFecha(int fecha) {
        return String.format(GET_FECHA, fecha);
    }
}
