package com.example.persistence;

import com.example.objects.Book;

public interface IBookPersistence {
    Book insertBook(Book currentBook);
}

