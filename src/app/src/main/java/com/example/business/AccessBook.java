package com.example.business;

import com.example.objects.Book;
import com.example.persistence.IBookPersistence;
import java.util.List;
import com.example.application.Services;
import java.util.Collections;

public class AccessBook {
    private List <Book> bookList;
    private IBookPersistence iBookPersistence;
    private Book book;
    private int currentBook;

    public AccessBook(){
        iBookPersistence = Services.getBookPersistence();
        book = null;
        currentBook =0;
    }
    public AccessBook(final IBookPersistence iBookPersistence){
        this();
        this.iBookPersistence = iBookPersistence;
    }

    public Book insertBook(Book currentBook){
        return iBookPersistence.insertBook(currentBook);
    }

    public List<Book> getBookList(){
        bookList = iBookPersistence.getBookList();
        return Collections.unmodifiableList(bookList);
    }

}
