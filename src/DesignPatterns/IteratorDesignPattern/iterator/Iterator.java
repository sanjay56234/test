package DesignPatterns.IteratorDesignPattern.iterator;

import DesignPatterns.IteratorDesignPattern.entities.Book;

public interface Iterator {

    public boolean next();

    public Book hasNext();

}
