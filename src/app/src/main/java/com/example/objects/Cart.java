package com.example.objects;

import java.util.ArrayList;

public class Cart
{
    private ArrayList<Book> books;

    public Cart()
    {
        books = new ArrayList<Book>();
    }

    public ArrayList<Book> getBooks()
    {
        return books;
    }

    public void addBook(Book newBook)
    {
        this.books.add(newBook);
    }
}
