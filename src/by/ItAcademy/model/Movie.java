package by.ItAcademy.model;

public class Movie {
    private String name;
    private String date;

    public Movie() {
    }

    public Movie(String name) {
        this.name = name;
    }

    public Movie(String name, String date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
