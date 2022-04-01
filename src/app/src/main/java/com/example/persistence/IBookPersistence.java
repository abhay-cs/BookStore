package com.example.persistence;

import java.util.ArrayList;
import com.example.objects.Book;

public interface IBookPersistence {
    boolean CreateDB();
    boolean ExecuteQuery(String query);
    boolean InsertBook(String title, String author, double price, String description, String genre);
    ArrayList<Book> GetBooks();
    void setDbPath(String dbPath);
}

