package com.uom.thebookstore.persistence;

import java.util.List;
import com.uom.thebookstore.objects.Book;

public interface IBookPersistence {
    Book insertBook(Book currentBook);
    List <Book> getBookList();

}

