package DesignPatterns.IteratorDesignPattern;

import DesignPatterns.IteratorDesignPattern.entities.Book;
import DesignPatterns.IteratorDesignPattern.entities.Library;
import DesignPatterns.IteratorDesignPattern.iterator.Iterator;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Book> bookList = Arrays.asList(
                new Book(10, "Book 1"),
                new Book(40, "Book 2")
        );

        Library library = new Library(bookList);
        Iterator iterator = library.getIterator();

        while (iterator.next()){
            System.out.println(iterator.hasNext().getName());
        }


    }
}
