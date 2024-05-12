package co.com.sofka.model;

public class CharacterModel {
    private int id;
    private String nombre;
    private String descripcion;
    private String copyright;

    public CharacterModel(int id, String nombre, String descripcion, String copyright) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.copyright = copyright;
    }

    public CharacterModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }
}
