// NAME: Ambrose Yancey    DATE: 02/25/2024

// COURSE: COMP 167      Section: 004

// DESCRIPTION
// Stores author, title, year, publisher, genre, rating, and price about a book using methods and getters

public class Book {
    //Defines variables
    private Author author;
    private String title;
    private int year;
    private String publisher;
    private String genre;
    private double rating;
    private double price;

    //Constructor initializes variables
    public Book () {
        this.author = new Author();
        title = "";
        year = 0;
        publisher = "";
        genre = "";
        rating = 0.0;
        price = 0.0;
    }

    //Constructor gives each variable a new value from input
    public Book (Author author, String title, int year, String publisher, String genre, double rating, double price) {
        this.author = author;
        this.title = title;
        this.year = year;
        this.publisher = publisher;
        this.genre = genre;
        this.rating = rating;
        this.price = price;
    }

    //Getters get values for the variables and returns them

    public Author getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    public double getPrice() {
        return price;
    }

    //Returns all the variables
    public String toString() {
        return "Title: " + title +
                ", Author: " + author.getFirstName() + " " + author.getLastName() +
                ", Year: " + year +
                ", Publisher: " + publisher +
                ", Genre: " + genre +
                ", Rating: " + rating +
                ", Price: $" + price;
    }
}
