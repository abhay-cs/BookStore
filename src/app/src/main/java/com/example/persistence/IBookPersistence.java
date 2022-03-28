package com.example.persistence;

import java.util.List;
import com.example.objects.Book;

public interface IBookPersistence {
    Book insertBook(Book currentBook);
    List <Book> getBookList();

}

