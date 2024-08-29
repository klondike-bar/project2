// NAME: Ambrose Yancey    DATE: 02/25/2024

// COURSE: COMP 167      Section: 004

// DESCRIPTION
// Helps search books by author, genre, and author. Allows books to be added and removed.

import java.util.ArrayList;
public class BookDatabase {
    private ArrayList<Book> books;

    //Constructor initializes ArrayList books
    public BookDatabase() {
        books = new ArrayList<>();
    }

    //Constructor gives books variable the value of ArrayList
    public BookDatabase(ArrayList<Book> booksRef) {
        this.books = booksRef;
    }

    //Getter and setter for ArrayList of books
    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> booksNew){
        this.books = booksNew;
    }

    //Methods that add/remove books from database
    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    //Search methods for author, year, and genre
    public ArrayList<Book> search (Author author) {
        ArrayList<Book> result = new ArrayList<>();
        for (int i = 0; i < this.books.size(); ++i) {
            if (books.get(i).getAuthor().getFirstName().matches(author.getFirstName()) &&
                    books.get(i).getAuthor().getLastName().matches(author.getLastName())) {
                result.add(this.books.get(i));
            }
        }
        return result;
    }

    public ArrayList<Book> search (int startYear, int endYear) {
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getYear() >= startYear && book.getYear() <= endYear) {
                result.add(book);
            }
        }
        return result;
    }

    public ArrayList<Book> search (String genre) {
        ArrayList<Book> result = new ArrayList<Book>();
        for (Book book : books) {
            if (book.getGenre().equalsIgnoreCase(genre)) {
                result.add(book);
            }
        }
        return result;
    }

    //Returns Book's toString with a newline
    public String toString() {
        String result = "";
        for (Book book : books) {
            result = result + book.toString() + "\n";
        }
        return result;
    }
}
