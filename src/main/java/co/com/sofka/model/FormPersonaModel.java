package co.com.sofka.model;

public class FormPersonaModel {
    private String correo;
    private String nombre;
    private String apellido;
    private String numerodoc;
    private String celular;

    private String ciudad;

    public FormPersonaModel(String correo, String nombre, String apellido, String numerodoc, String celular, String ciudad) {
        this.correo = correo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numerodoc = numerodoc;
        this.celular = celular;
        this.ciudad = ciudad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumerodoc() {
        return numerodoc;
    }

    public void setNumerodoc(String numerodoc) {
        this.numerodoc = numerodoc;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
