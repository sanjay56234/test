package DesignPatterns.IteratorDesignPattern.iterator;

import DesignPatterns.IteratorDesignPattern.entities.Book;

import java.util.List;

public class ListIterator implements Iterator{

    List<Book> bookList;

    int index = 0;

    public ListIterator(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public boolean next() {
        return index < bookList.size();
    }

    @Override
    public Book hasNext() {
        Book book = bookList.get(index);
        index+=1;
        return book;
    }
}
