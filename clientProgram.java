// NAME: Ambrose Yancey    DATE: 02/25/2024

// COURSE: COMP 167      Section: 004

// DESCRIPTION
// clientProgram allows the user to search by author, genre, or year
// Searches the database for books matching with the user input and outputs those books

import java.util.Scanner;
import java.util.ArrayList;

public class clientProgram {
    public static void main(String[] args) {
        //Initializes BookDatabase
        BookDatabase database = new BookDatabase();

        try {
            //Reads dataset.csv
            Scanner scnr = new Scanner(new java.io.FileInputStream("dataset.csv"));
            scnr.nextLine();

            //Goes through each line and adds information to database
            while (scnr.hasNextLine()) {
                String line = scnr.nextLine();
                String[] cells = line.split(",");
                String authorFirstName = cells[0];
                String authorLastName = cells[1];
                String title = cells[2];
                int year = Integer.parseInt(cells[3]);
                String genre = cells[4];
                String publisher = cells[5];
                double rating = Double.parseDouble(cells[6]);
                double price = Double.parseDouble(cells[7].replace("$", ""));

                //Create Author and Book objects with values from while loop
                Author author = new Author(authorFirstName, authorLastName);
                Book book = new Book(author, title, year, publisher, genre, rating, price);
                database.addBook(book);
            }

        } catch (Exception e) {
            System.out.println("Error");
        }

        Scanner inputscnr = new Scanner(System.in);

        //Initializes variables
        Author inputauthor = new Author("", "");
        String authorFirstNameinput;
        String authorLastNameinput;
        String inputgenre;
        int startYear;
        int endYear;


        //Asks user how they would like to search
        System.out.print("Search by Author, Genre, Year, or None: ");
        String userInput = inputscnr.nextLine();

        //Gets author from user if user chooses author
        if (userInput.equalsIgnoreCase("Author")) {
            System.out.print("Enter the author's firstname: ");
            authorFirstNameinput = inputscnr.next();

            System.out.print("Enter the author's lastname: ");
            authorLastNameinput = inputscnr.next();

            System.out.println();

            //Searches database and prints out all books with same author name
            inputauthor = new Author(authorFirstNameinput, authorLastNameinput);
            ArrayList<Book> AuthorThing = database.search(inputauthor);
            for (Book book : AuthorThing) {
                System.out.println(book);
            }
            System.out.println();
        }

        //Gets genre from user if user chooses genre
        else if (userInput.equalsIgnoreCase("Genre")) {
            System.out.print("Enter the genre's name: ");
            inputgenre = inputscnr.nextLine();

            System.out.println();

            //Searches database and prints out all books with same genre
            ArrayList<Book> GenreThing = database.search(inputgenre);
            for (Book books : GenreThing) {
                System.out.println(books);
            }
            System.out.println();
        }

        //Gets startYear and endYear from user if user chooses year
        else if (userInput.equalsIgnoreCase("Year")) {
            System.out.print("Enter the starting year: ");
            startYear = inputscnr.nextInt();
            System.out.print("Enter the ending year: ");
            endYear = inputscnr.nextInt();

            System.out.println();

            //Searches database and prints out all books within the range of startYear and endYear
            ArrayList<Book> Year = database.search(startYear, endYear);
            for (Book books : Year) {
                System.out.println(books);
            }
            System.out.println();
        }

        //Prints out entire database if user chooses none
        else if (userInput.equalsIgnoreCase("None")){
            System.out.println("Printing Database... ");

            System.out.println();

            System.out.print(database);
        }
    }
}
