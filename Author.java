// NAME: Ambrose Yancey    DATE: 02/25/2024

// COURSE: COMP 167      Section: 004

// DESCRIPTION
// Stores author's first and last name by using methods, getters, and setters

public class Author {
    //Defines variables
    private String firstName;
    private String lastName;

    //Constructor initializes variables
    public Author() {
        firstName = "";
        lastName = "";
    }

    //Constructor gives each variable a new value from input
    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //Getters get values for the variables and returns them
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    //Setters set values for the variables
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //Returns the author's first and last name
    public String toString(){
        return firstName + " " + lastName;
    }
}
