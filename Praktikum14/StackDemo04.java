package Praktikum14;

import java.util.Stack;

public class StackDemo04 {
    public static void main(String[] args) {
        Book04 book1 = new Book04("1234", "Dasar Pemrograman");
        Book04 book2 = new Book04("7145", "Hafalan Shalat Delisa");
        Book04 book3 = new Book04("3562", "Muhammad Al-Fatih");

        Stack<Book04> books = new Stack<>();
        books.push(book1);
        books.push(book2);
        books.push(book3);

        Book04 temp = books.peek();
        if (temp != null) {
            System.out.println(temp.toString());
        }

        Book04 temp2 = books.pop();
        if (temp2 != null) {
            System.out.println(temp2.toString());
        }

        for (Book04 book : books) {
            System.out.println(book.toString());
        }

        System.out.println(books);
    }
}
