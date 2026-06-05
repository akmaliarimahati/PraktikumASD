package Praktikum14;

public class Book04 {
    public String isbn;
    public String title; 

    public Book04() {

    }

    public Book04(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    public String toString() {
        return "ISBN: " + this.isbn + " Title: " + this.title;
    }
}
