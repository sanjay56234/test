package DesignPatterns.IteratorDesignPattern.entities;

import DesignPatterns.IteratorDesignPattern.iterator.Iterator;
import DesignPatterns.IteratorDesignPattern.iterator.ListIterator;

import java.util.List;

public class Library {

    List<Book> bookList;

    public Library(List<Book> bookList) {
        this.bookList = bookList;
    }

    public Iterator getIterator(){
        return new ListIterator(bookList);
    }
}
