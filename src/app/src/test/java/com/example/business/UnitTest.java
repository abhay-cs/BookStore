package com.example.business;

import org.junit.Test;
import com.example.business.DatabaseHandler;
import com.example.objects.Book;
import java.util.ArrayList;

public class UnitTest
{
    @Test
    public void verifyBooks()
    {
        DatabaseHandler db;
        db = new DatabaseHandler("UOM");

        assert (db!=null);

        // Clear the Books table
        Boolean bReset = db.ResetBooksDB();
        //assert(bReset != false);

        Boolean bInserted = false;

        bInserted = db.addBook("Book ONE","Souvik Ray", 123.45,  "An interesting book", "Sci-Fi");
        assert(bInserted != false);

        bInserted = db.addBook("Book TWO","Souvik Ray", 234.56,  "Read this book", "Romance");
        assert(bInserted != false);

        bInserted = db.addBook("Book THREE","Souvik Ray", 345.67,  "A must read", "Ancient History");
        assert(bInserted != false);

        ArrayList<Book> books =  db.getBooks();

        // There must be only 3 books
        assert(books.size() == 3);

        assert(books.get(0).getAuthor().equals("Souvik Ray"));
        System.out.println("verifyBooks is successful");
    }
}
