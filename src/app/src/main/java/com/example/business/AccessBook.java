package com.example.business;

import com.example.objects.Book;
import com.example.persistence.IBookPersistence;
import java.util.List;
import com.example.application.Services;

public class AccessBook {
    private List <Book> bookList;
    private IBookPersistence iBookPersistence;

    public AccessBook(){
        iBookPersistence = Services.getBookPersistence();
    }
    public Book insertBook(Book currentBook){
        return iBookPersistence.insertBook(currentBook);
    }

}
