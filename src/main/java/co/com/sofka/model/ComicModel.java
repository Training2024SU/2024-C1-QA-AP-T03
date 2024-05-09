package co.com.sofka.model;

public class ComicModel {
    private int id;
    private String format;
    private String title;
    private String description;

    private String isbn;

    public ComicModel(int id, String format, String title, String description, String isbn) {
        this.id = id;
        this.format = format;
        this.title = title;
        this.description = description;
        this.isbn = isbn;
    }

    public ComicModel() {
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
