package co.com.sofka.util;

import co.com.sofka.model.FormularioModel;

public class Util {

    public static FormularioModel crearUsuario(){
        FormularioModel formularioModel = new FormularioModel();
        formularioModel.setEmail("Varobass0@gmail.com");
        formularioModel.setContrasena("Zonafit123");
        return formularioModel;
    }
}
