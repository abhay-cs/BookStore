package com.example.application;
import com.example.persistence.IBookPersistence;
import com.example.persistence.hsqldb.BookPersistence;

public class Services {
    private static BookPersistence bookPersistence = null;

    public static synchronized IBookPersistence getBookPersistence(){
        if (bookPersistence == null){
            bookPersistence = new BookPersistence(Main.getDBPathName());
        }
        return bookPersistence;
    }
}
