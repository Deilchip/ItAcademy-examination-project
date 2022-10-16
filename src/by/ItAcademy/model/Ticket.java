package by.ItAcademy.model;

public class Ticket {
    private int id;
    private User user;
    private int place;
    private float price;
    private Movie movie;



    private String name;
    private boolean exist = true;

    public Ticket() {
    }

    public Ticket(User user, int place, String name) {
        this.user = user;
        this.place = place;
        this.id=place;
        this.exist=false;
        this.name=name;
    }

    public Ticket(User user, int place) {
        this.place = place;
        this.price = price;
    }

    public int getId() {
        return id;
    }
    public String getName() { return name; }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isExist() {
        return exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}

